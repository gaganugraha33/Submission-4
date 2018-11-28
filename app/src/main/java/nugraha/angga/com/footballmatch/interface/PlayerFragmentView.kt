package nugraha.angga.com.footballmatch.`interface`

import nugraha.angga.com.footballmatch.model.playerModel.Player

interface PlayerFragmentView {
    fun showLoading()
    fun hideLoading()
    fun showPlayerList(data:List<Player>?)
}