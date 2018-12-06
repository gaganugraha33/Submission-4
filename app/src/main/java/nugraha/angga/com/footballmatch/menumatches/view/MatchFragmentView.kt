package nugraha.angga.com.footballmatch.menumatches.view

import nugraha.angga.com.footballmatch.model.allLeagueModel.League
import nugraha.angga.com.footballmatch.model.eventMatchModel.EventMatch

interface MatchFragmentView {
    fun showLoading()
    fun hideLoading()
    fun showMatchList(data:List<EventMatch>?)
    fun showListAllLeague(data:List<League>?)
}