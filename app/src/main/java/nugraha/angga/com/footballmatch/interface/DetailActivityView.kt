package nugraha.angga.com.footballmatch.`interface`

import nugraha.angga.com.footballmatch.model.allTeamLeagueModel.Team

interface DetailActivityView {
    fun showLoading()
    fun hideLoading()
    fun showAllteam(dataAllteam: List<Team>?)
}