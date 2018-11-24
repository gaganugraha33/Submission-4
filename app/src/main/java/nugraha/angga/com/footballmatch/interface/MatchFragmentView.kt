package nugraha.angga.com.footballmatch.`interface`

import nugraha.angga.com.footballmatch.model.eventMatchModel.EventMatch

interface MatchFragmentView {
    fun showLoading()
    fun hideLoading()
    fun showMatchList(data:List<EventMatch>?)
}