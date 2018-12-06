package nugraha.angga.com.footballmatch.menufavorite.menufavoriteteam.presenter

import android.content.Context
import nugraha.angga.com.footballmatch.db.TeamFavorite
import nugraha.angga.com.footballmatch.db.databaseTeam
import nugraha.angga.com.footballmatch.menufavorite.menufavoriteteam.view.TeamFavoriteFragmentView
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select


class TeamsFavoriteFragmentPresenter(private val view: TeamFavoriteFragmentView,
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