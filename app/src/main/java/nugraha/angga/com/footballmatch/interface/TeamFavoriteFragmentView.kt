package nugraha.angga.com.footballmatch.`interface`

import nugraha.angga.com.footballmatch.db.TeamFavorite

interface TeamFavoriteFragmentView {
    fun showLoading()
    fun hideLoading()
    fun showAllTeamFavorite(dataTeamFavorite: List<TeamFavorite>?)
}