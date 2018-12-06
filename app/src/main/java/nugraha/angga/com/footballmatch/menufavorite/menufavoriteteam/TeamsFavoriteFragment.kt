package nugraha.angga.com.footballmatch.menufavorite.menufavoriteteam
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.*
import kotlinx.android.synthetic.main.match_layout.*
import nugraha.angga.com.footballmatch.R
import nugraha.angga.com.footballmatch.menuteam.adapter.AllTeamAdapter
import nugraha.angga.com.footballmatch.model.allTeamLeagueModel.Team
import org.jetbrains.anko.support.v4.onRefresh
import nugraha.angga.com.footballmatch.db.TeamFavorite
import nugraha.angga.com.footballmatch.menufavorite.menufavoriteteam.presenter.TeamsFavoriteFragmentPresenter
import nugraha.angga.com.footballmatch.menufavorite.menufavoriteteam.view.TeamFavoriteFragmentView
import nugraha.angga.com.footballmatch.menudetailteam.TeamDetailActivity
import java.io.Serializable


class TeamsFavoriteFragment :Fragment(), TeamFavoriteFragmentView {
    private lateinit var teamFavoriteFragmentPresenter: TeamsFavoriteFragmentPresenter
    private lateinit var allTeamAdapter: AllTeamAdapter
    private var allTeamList:MutableList<Team> = mutableListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.match_layout, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvMatch.layoutManager = LinearLayoutManager(context)
        spinner_teams.visibility = View.GONE

        allTeamAdapter = AllTeamAdapter(allTeamList) {
            val intentDetail = Intent(context, TeamDetailActivity::class.java)
            intentDetail.putExtra("data", it as Serializable)
            startActivity(intentDetail)
        }
        rvMatch.adapter = allTeamAdapter

        teamFavoriteFragmentPresenter = TeamsFavoriteFragmentPresenter(this, context)
        teamFavoriteFragmentPresenter.getFavoriteTeam()


        swpLayout.onRefresh {
            teamFavoriteFragmentPresenter.getFavoriteTeam()
        }
    }

    override fun showLoading() {
      swpLayout.isRefreshing = true
    }

    override fun hideLoading() {
        swpLayout.isRefreshing = false
    }

    override fun showAllTeamFavorite(dataTeamFavorite: List<TeamFavorite>?) {
        swpLayout.isRefreshing = false
        allTeamList.clear()

        if (dataTeamFavorite != null) {
            for (i in dataTeamFavorite.indices){
                val team = Team()
                team.idTeam = dataTeamFavorite.get(i).idTeam
                team.strTeam = dataTeamFavorite.get(i).strTeam
                team.strTeamBadge = dataTeamFavorite.get(i).strTeamBadge
                team.intFormedYear = dataTeamFavorite.get(i).intFormedYear
                team.strStadium = dataTeamFavorite.get(i).strStadium
                team.strDescriptionEN = dataTeamFavorite.get(i).strDescriptionEN
                allTeamList.add(team)
            }
        }

        allTeamAdapter.notifyDataSetChanged()
    }

    override fun onResume() {
        super.onResume()
        teamFavoriteFragmentPresenter.getFavoriteTeam()
    }



}