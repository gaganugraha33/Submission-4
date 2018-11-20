package nugraha.angga.com.footballmatch

import com.google.gson.Gson
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import nugraha.angga.com.footballmatch.`interface`.MatchFragmentView
import nugraha.angga.com.footballmatch.api.ServiceSportDBApi
import nugraha.angga.com.footballmatch.api.SportDBRepository
import nugraha.angga.com.footballmatch.model.EventMatchModel.EventMatch
import nugraha.angga.com.footballmatch.model.EventMatchModel.EventMatchResponse
import nugraha.angga.com.footballmatch.model.EventMatchModel.MatchFootbal
import nugraha.angga.com.footballmatch.presenter.MatchFragmentPresenter
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.junit.ClassRule



class PresenterMatchTest {

    @Mock
    private
    lateinit var view: MatchFragmentView

    @Mock
    private
    lateinit var compositeDisposable: CompositeDisposable

    @Mock
    private
    lateinit var apiRepositoryTest: SportDBRepository

    @Mock
    private
    lateinit var matchFragmentPresenter: MatchFragmentPresenter

    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
        matchFragmentPresenter = MatchFragmentPresenter(view, compositeDisposable, apiRepositoryTest)
    }

    @Test
    fun getTestMatchList(){
        val listEventMatch: MutableList<EventMatch> = mutableListOf()
        var response =  EventMatchResponse(listEventMatch)


        `when`(compositeDisposable.add(
                apiRepositoryTest.lastMatchReq()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe ({
                            EventMatch ->
                        }, { error ->
                            error.printStackTrace()
                        })
        )
        ).thenReturn(response)

        matchFragmentPresenter.getMatchList()

        Mockito.verify(view).showLoading()
        Mockito.verify(view).hideLoading()
        Mockito.verify(view).showMatchList(listEventMatch)
    }
}