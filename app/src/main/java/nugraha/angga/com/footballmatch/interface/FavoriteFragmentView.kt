package nugraha.angga.com.footballmatch.`interface`

import nugraha.angga.com.footballmatch.db.Favorite

interface FavoriteFragmentView {
    fun showLoading()
    fun hideLoading()
    fun showAllFavorite(dataFavorite: List<Favorite>?)
}