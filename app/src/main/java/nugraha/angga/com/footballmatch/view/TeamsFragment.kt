package nugraha.angga.com.footballmatch.view
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
import kotlinx.android.synthetic.main.match_layout.*
import nugraha.angga.com.footballmatch.R
import nugraha.angga.com.footballmatch.`interface`.AllTeamFragmentView
import nugraha.angga.com.footballmatch.`interface`.MatchFragmentView
import nugraha.angga.com.footballmatch.adapter.AllTeamAdapter
import nugraha.angga.com.footballmatch.adapter.MatchAdapter
import nugraha.angga.com.footballmatch.api.ServiceSportDBProvider
import nugraha.angga.com.footballmatch.model.allTeamLeagueModel.Team
import nugraha.angga.com.footballmatch.model.eventMatchModel.EventMatch
import nugraha.angga.com.footballmatch.presenter.MatchFragmentPresenter
import nugraha.angga.com.footballmatch.presenter.TeamFragmentPresenter
import org.jetbrains.anko.support.v4.onRefresh
import java.io.Serializable

class TeamsFragment :Fragment(), AllTeamFragmentView {


    private lateinit var teamFragmentPresenter: TeamFragmentPresenter
    private lateinit var allTeamAdapter: AllTeamAdapter
    private var allTeamList:MutableList<Team> = mutableListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.match_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvMatch.layoutManager = LinearLayoutManager(context)
        allTeamAdapter = AllTeamAdapter(allTeamList){
//            val intentDetail = Intent(context, DetaillActivity::class.java)
//            intentDetail.putExtra("data", it as Serializable)
//            startActivity(intentDetail)
        }
        rvMatch.adapter = allTeamAdapter

        val compositeDisposable: CompositeDisposable = CompositeDisposable()
        val repository = ServiceSportDBProvider.providerLastMatchRepository()

        teamFragmentPresenter = TeamFragmentPresenter(this, compositeDisposable, repository, AndroidSchedulers.mainThread(),Schedulers.io())
        teamFragmentPresenter.getAllTeamList()


        swpLayout.onRefresh {
            teamFragmentPresenter.getAllTeamList()
        }
    }

    override fun showLoading() {
      swpLayout.isRefreshing = true
    }

    override fun hideLoading() {
        swpLayout.isRefreshing = false
    }

    override fun showListAllTeam(data: List<Team>?) {
        swpLayout.isRefreshing = false
        allTeamList.clear()
        data?.let { allTeamList.addAll(it) }
        allTeamAdapter.notifyDataSetChanged()
    }

}