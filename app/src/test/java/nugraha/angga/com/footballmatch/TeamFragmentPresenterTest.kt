package nugraha.angga.com.footballmatch

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import nugraha.angga.com.footballmatch.menuteam.view.AllTeamFragmentView
import nugraha.angga.com.footballmatch.api.SportDBRepository
import nugraha.angga.com.footballmatch.model.allLeagueModel.AllLeague
import nugraha.angga.com.footballmatch.model.allLeagueModel.League
import nugraha.angga.com.footballmatch.model.allTeamLeagueModel.AllTeamLeague
import nugraha.angga.com.footballmatch.model.allTeamLeagueModel.Team
import nugraha.angga.com.footballmatch.menuteam.presenter.TeamFragmentPresenter
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations


class TeamFragmentPresenterTest {

    @Mock
    private
    lateinit var view: AllTeamFragmentView

    @Mock
    private
    lateinit var compositeDisposable: CompositeDisposable

    @Mock
    private
    lateinit var apiRepositoryTest: SportDBRepository

    @Mock
    private
    lateinit var teamFragmentPresenter: TeamFragmentPresenter

    @Mock
    private
    lateinit var responseLeague: AllTeamLeague

    @Mock
    private
    lateinit var responseAllLeague: AllLeague


    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun getTestMatchList(){
        val listTeam: MutableList<Team> = mutableListOf()

        `when`(apiRepositoryTest.allTeamReq("4328")
        ).thenReturn(Observable.just(responseLeague))

        teamFragmentPresenter = TeamFragmentPresenter(view, compositeDisposable, apiRepositoryTest, Schedulers.trampoline(), Schedulers.trampoline())
        teamFragmentPresenter.getAllTeamList("4328")

        responseLeague.teams?.let { listTeam.addAll(it) }

        Mockito.verify(view).showLoading()
        Mockito.verify(view).hideLoading()
        Mockito.verify(view).showListAllTeam(listTeam)
    }

    @Test
    fun getTestSearchTeamList(){
        val listTeam: MutableList<Team> = mutableListOf()

        `when`(apiRepositoryTest.allTeamSearchReq("Arsenal")
        ).thenReturn(Observable.just(responseLeague))

        teamFragmentPresenter = TeamFragmentPresenter(view, compositeDisposable, apiRepositoryTest, Schedulers.trampoline(), Schedulers.trampoline())
        teamFragmentPresenter.getSearchTeamList("Arsenal")

        responseLeague.teams?.let { listTeam.addAll(it) }

        Mockito.verify(view).showLoading()
        Mockito.verify(view).hideLoading()
        Mockito.verify(view).showListAllTeam(listTeam)
    }

    @Test
    fun getTestAllLeague(){
        val listAllLeague: MutableList<League> = mutableListOf()

        `when`(apiRepositoryTest.allLeague()
        ).thenReturn(Observable.just(responseAllLeague))

        teamFragmentPresenter = TeamFragmentPresenter(view, compositeDisposable, apiRepositoryTest, Schedulers.trampoline(), Schedulers.trampoline())
        teamFragmentPresenter.getAllLeague()

        responseAllLeague.leagues?.let { listAllLeague.addAll(it) }

        Mockito.verify(view).showLoading()
        Mockito.verify(view).hideLoading()
        Mockito.verify(view).showListAllLeague(listAllLeague)
    }

}