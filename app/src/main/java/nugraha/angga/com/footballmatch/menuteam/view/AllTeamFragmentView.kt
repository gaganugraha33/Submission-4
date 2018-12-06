package nugraha.angga.com.footballmatch.menuteam.view

import nugraha.angga.com.footballmatch.model.allLeagueModel.League
import nugraha.angga.com.footballmatch.model.allTeamLeagueModel.Team

interface AllTeamFragmentView {
    fun showLoading()
    fun hideLoading()
    fun showListAllTeam(data:List<Team>?)
    fun showListAllLeague(data:List<League>?)
}