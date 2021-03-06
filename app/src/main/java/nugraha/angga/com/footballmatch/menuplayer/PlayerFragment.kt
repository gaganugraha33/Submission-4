package nugraha.angga.com.footballmatch.menuplayer
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.player_layout.*
import nugraha.angga.com.footballmatch.R
import nugraha.angga.com.footballmatch.menuplayer.adapter.PlayerAdapter
import nugraha.angga.com.footballmatch.api.ServiceSportDBProvider
import nugraha.angga.com.footballmatch.menuplayer.presenter.PlayerFragmentPresenter
import nugraha.angga.com.footballmatch.menuplayer.view.PlayerFragmentView
import nugraha.angga.com.footballmatch.model.playerModel.Player
import nugraha.angga.com.footballmatch.menudetailplayer.PlayerDetailActivity
import org.jetbrains.anko.support.v4.onRefresh
import java.io.Serializable

class PlayerFragment :Fragment() , PlayerFragmentView {
    private lateinit var playerFragmentPresenter: PlayerFragmentPresenter
    private lateinit var playerAdapter: PlayerAdapter
    private var playerData:MutableList<Player> = mutableListOf()

    companion object{
        private var nameClubPlayer:String? = null

        fun newInstance(nameClub:String): PlayerFragment {
            nameClubPlayer = nameClub
            val fragment = PlayerFragment()
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.player_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvPlayer.layoutManager = LinearLayoutManager(context)
        playerAdapter = PlayerAdapter(playerData) {
            val intentDetail = Intent(context, PlayerDetailActivity::class.java)
            intentDetail.putExtra("data", it as Serializable)
            startActivity(intentDetail)
        }
        rvPlayer.adapter = playerAdapter

        val compositeDisposable: CompositeDisposable = CompositeDisposable()
        val repository = ServiceSportDBProvider.providerPlayerRepository()


        playerFragmentPresenter = PlayerFragmentPresenter(this, compositeDisposable, repository, AndroidSchedulers.mainThread(), Schedulers.io())
        playerFragmentPresenter.getPlayerList(nameClubPlayer.toString())

        swp_player.onRefresh {
            playerFragmentPresenter.getPlayerList(nameClubPlayer.toString())
        }

    }

    override fun hideLoading() {
        swp_player.isRefreshing = true
    }

    override fun showPlayerList(data: List<Player>?) {
        swp_player.isRefreshing = false
        playerData.clear()
        data?.let { playerData.addAll(it) }
        playerAdapter.notifyDataSetChanged()
    }

    override fun showLoading() {
        swp_player.isRefreshing = false
    }

}