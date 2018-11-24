package nugraha.angga.com.footballmatch.presenter

import android.content.Context
import nugraha.angga.com.footballmatch.`interface`.FavoriteFragmentView
import nugraha.angga.com.footballmatch.db.Favorite
import nugraha.angga.com.footballmatch.db.database
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select


class FavoriteFragmentPresenter(private val view:FavoriteFragmentView,
                                private val context: Context?) {

    fun getFavorite(){
        view.showLoading()
        context?.database?.use {
            val result = select(Favorite.TABLE_FAVORITE)
            val favorite = result.parseList(classParser<Favorite>())

            view.hideLoading()
            view.showAllFavorite(favorite)
        }
    }

}