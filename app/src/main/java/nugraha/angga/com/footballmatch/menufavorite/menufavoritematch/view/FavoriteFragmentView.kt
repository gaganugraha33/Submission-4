package nugraha.angga.com.footballmatch.menufavorite.menufavoritematch.view

import nugraha.angga.com.footballmatch.db.Favorite

interface FavoriteFragmentView {
    fun showLoading()
    fun hideLoading()
    fun showAllFavorite(dataFavorite: List<Favorite>?)
}