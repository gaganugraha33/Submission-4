package nugraha.angga.com.footballmatch

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import nugraha.angga.com.footballmatch.menudetailmatch.view.DetailActivityView
import nugraha.angga.com.footballmatch.api.SportDBRepository
import nugraha.angga.com.footballmatch.model.allTeamLeagueModel.AllTeamLeague
import nugraha.angga.com.footballmatch.model.allTeamLeagueModel.Team
import nugraha.angga.com.footballmatch.menudetailmatch.presenter.DetailActivityPresenter
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

        Mockito.`when`(apiRepositoryTest.allTeamReq("4328")
        ).thenReturn(Observable.just(response))

        detailActivityPresenter = DetailActivityPresenter(view, compositeDisposable, apiRepositoryTest, Schedulers.trampoline(), Schedulers.trampoline())
        detailActivityPresenter.getAllTeamLeagueList("4328")

        response.teams?.let { listTeam.addAll(it) }

        Mockito.verify(view).showLoading()
        Mockito.verify(view).hideLoading()
        Mockito.verify(view).showAllteam(listTeam)
    }

}