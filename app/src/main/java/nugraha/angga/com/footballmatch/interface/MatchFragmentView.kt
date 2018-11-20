package nugraha.angga.com.footballmatch.`interface`

import nugraha.angga.com.footballmatch.model.AllTeamLeagueModel.Team
import nugraha.angga.com.footballmatch.model.EventMatchModel.EventMatch

interface MatchFragmentView {
    fun showLoading()
    fun hideLoading()
    fun showMatchList(data:List<EventMatch>?)
}