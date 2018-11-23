package nugraha.angga.com.footballmatch

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import nugraha.angga.com.footballmatch.`interface`.DetailActivityView
import nugraha.angga.com.footballmatch.`interface`.MatchFragmentView
import nugraha.angga.com.footballmatch.api.SportDBRepository
import nugraha.angga.com.footballmatch.model.AllTeamLeagueModel.AllTeamLeague
import nugraha.angga.com.footballmatch.model.AllTeamLeagueModel.Team
import nugraha.angga.com.footballmatch.model.EventMatchModel.EventMatch
import nugraha.angga.com.footballmatch.model.EventMatchModel.MatchFootbal
import nugraha.angga.com.footballmatch.presenter.DetailActivityPresenter
import nugraha.angga.com.footballmatch.presenter.MatchFragmentPresenter
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class DetailActivityPresenterTest {

    @Mock
    private
    lateinit var view: DetailActivityView

    @Mock
    private
    lateinit var compositeDisposable: CompositeDisposable

    @Mock
    private
    lateinit var apiRepositoryTest: SportDBRepository

    @Mock
    private
    lateinit var detailActivityPresenter: DetailActivityPresenter

    @Mock
    private
    lateinit var response: AllTeamLeague

    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun getAllTeamLeagueList(){
        val listTeam: MutableList<Team> = mutableListOf()

        Mockito.`when`(apiRepositoryTest.allTeamReq()
        ).thenReturn(Observable.just(response))

        detailActivityPresenter = DetailActivityPresenter(view, compositeDisposable, apiRepositoryTest, Schedulers.trampoline(), Schedulers.trampoline())
        detailActivityPresenter.getAllTeamLeagueList()

        response?.teams?.let { listTeam.addAll(it) }

        Mockito.verify(view).showLoading()
        Mockito.verify(view).hideLoading()
        Mockito.verify(view).showAllteam(listTeam)
    }

}