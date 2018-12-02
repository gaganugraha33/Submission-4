package nugraha.angga.com.footballmatch.presenter

import android.content.Context
import nugraha.angga.com.footballmatch.`interface`.FavoriteFragmentView
import nugraha.angga.com.footballmatch.`interface`.TeamFavoriteFragmentView
import nugraha.angga.com.footballmatch.db.Favorite
import nugraha.angga.com.footballmatch.db.TeamFavorite
import nugraha.angga.com.footballmatch.db.database
import nugraha.angga.com.footballmatch.db.databaseTeam
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select


class TeamsFavoriteFragmentPresenter(private val view:TeamFavoriteFragmentView,
                                     private val context: Context?) {

    fun getFavoriteTeam(){
        view.showLoading()
        context?.databaseTeam?.use {
            val result = select(TeamFavorite.TABLE_FAVORITE)
            val favorite = result.parseList(classParser<TeamFavorite>())

            view.hideLoading()
            view.showAllTeamFavorite(favorite)
        }
    }

}