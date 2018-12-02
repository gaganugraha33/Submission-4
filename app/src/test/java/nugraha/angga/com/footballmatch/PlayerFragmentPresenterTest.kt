package nugraha.angga.com.footballmatch

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import nugraha.angga.com.footballmatch.`interface`.PlayerFragmentView
import nugraha.angga.com.footballmatch.api.SportDBRepository
import nugraha.angga.com.footballmatch.model.eventMatchModel.EventMatch
import nugraha.angga.com.footballmatch.model.playerModel.Player
import nugraha.angga.com.footballmatch.model.playerModel.PlayerData
import nugraha.angga.com.footballmatch.presenter.PlayerFragmentPresenter
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations


class PlayerFragmentPresenterTest {

    @Mock
    private
    lateinit var view: PlayerFragmentView

    @Mock
    private
    lateinit var compositeDisposable: CompositeDisposable

    @Mock
    private
    lateinit var apiRepositoryTest: SportDBRepository

    @Mock
    private
    lateinit var playerFragmentPresenter: PlayerFragmentPresenter

    @Mock
    private
    lateinit var response: PlayerData


    @Before
    fun setup(){
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun getTestMatchList(){
        val listPlayer: MutableList<Player> = mutableListOf()

        `when`(apiRepositoryTest.allPlayer("Arsenal")
        ).thenReturn(Observable.just(response))

        playerFragmentPresenter = PlayerFragmentPresenter(view, compositeDisposable, apiRepositoryTest, Schedulers.trampoline(), Schedulers.trampoline())
        playerFragmentPresenter.getPlayerList("Arsenal")

        response.player?.let { listPlayer.addAll(it) }

        Mockito.verify(view).showLoading()
        Mockito.verify(view).hideLoading()
        Mockito.verify(view).showPlayerList(listPlayer)
    }

}