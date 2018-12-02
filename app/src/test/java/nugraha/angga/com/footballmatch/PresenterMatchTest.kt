package nugraha.angga.com.footballmatch

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import nugraha.angga.com.footballmatch.`interface`.MatchFragmentView
import nugraha.angga.com.footballmatch.api.SportDBRepository
import nugraha.angga.com.footballmatch.model.allLeagueModel.AllLeague
import nugraha.angga.com.footballmatch.model.allLeagueModel.League
import nugraha.angga.com.footballmatch.model.eventMatchModel.EventMatch
import nugraha.angga.com.footballmatch.model.eventMatchModel.MatchFootbal
import nugraha.angga.com.footballmatch.model.eventMatchModel.MatchFootbalSearch
import nugraha.angga.com.footballmatch.presenter.MatchFragmentPresenter
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations


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

    @Mock
    private
    lateinit var response: MatchFootbal

    @Mock
    private
    lateinit var responseSearch: MatchFootbalSearch

    @Mock
    private
    lateinit var responseLeague: AllLeague

    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun getTestMatchList(){
        val listEventMatch: MutableList<EventMatch> = mutableListOf()

        `when`(apiRepositoryTest.lastMatchReq("4328")
        ).thenReturn(Observable.just(response))

        matchFragmentPresenter = MatchFragmentPresenter(view, compositeDisposable, apiRepositoryTest, Schedulers.trampoline(), Schedulers.trampoline())
        matchFragmentPresenter.getMatchList("4328")

        response.events?.let { listEventMatch.addAll(it) }

        Mockito.verify(view).showLoading()
        Mockito.verify(view).hideLoading()
        Mockito.verify(view).showMatchList(listEventMatch)
    }

    @Test
    fun getTestNextMatchList(){
        val listEventMatch: MutableList<EventMatch> = mutableListOf()

        `when`(apiRepositoryTest.nextMatchReq("4328")
        ).thenReturn(Observable.just(response))

        matchFragmentPresenter = MatchFragmentPresenter(view, compositeDisposable, apiRepositoryTest, Schedulers.trampoline(), Schedulers.trampoline())
        matchFragmentPresenter.getNextMatchList("4328")

        response.events?.let { listEventMatch.addAll(it) }

        Mockito.verify(view).showLoading()
        Mockito.verify(view).hideLoading()
        Mockito.verify(view).showMatchList(listEventMatch)
    }

    @Test
    fun getTestSearchMatchList(){
        val listEventMatch: MutableList<EventMatch> = mutableListOf()

        `when`(apiRepositoryTest.searchEvent("Arsenal")
        ).thenReturn(Observable.just(responseSearch))

        matchFragmentPresenter = MatchFragmentPresenter(view, compositeDisposable, apiRepositoryTest, Schedulers.trampoline(), Schedulers.trampoline())
        matchFragmentPresenter.getSearchMatchList("Arsenal")

        responseSearch.event?.let { listEventMatch.addAll(it) }

        Mockito.verify(view).showLoading()
        Mockito.verify(view).hideLoading()
        Mockito.verify(view).showMatchList(listEventMatch)
    }

    @Test
    fun getTestAllLeague(){
        val listLeague: MutableList<League> = mutableListOf()

        `when`(apiRepositoryTest.allLeague()
        ).thenReturn(Observable.just(responseLeague))

        matchFragmentPresenter = MatchFragmentPresenter(view, compositeDisposable, apiRepositoryTest, Schedulers.trampoline(), Schedulers.trampoline())
        matchFragmentPresenter.getAllLeague()

        responseLeague.leagues?.let { listLeague.addAll(it) }

        Mockito.verify(view).showLoading()
        Mockito.verify(view).hideLoading()
        Mockito.verify(view).showListAllLeague(listLeague)
    }

}