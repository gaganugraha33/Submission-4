package nugraha.angga.com.footballmatch.view

import android.database.sqlite.SQLiteConstraintException
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.bumptech.glide.Glide
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.detail_activity_layout.*
import nugraha.angga.com.footballmatch.R
import nugraha.angga.com.footballmatch.`interface`.DetailActivityView
import nugraha.angga.com.footballmatch.api.ServiceSportDBProvider
import nugraha.angga.com.footballmatch.db.Favorite
import nugraha.angga.com.footballmatch.db.database
import nugraha.angga.com.footballmatch.model.allTeamLeagueModel.Team
import nugraha.angga.com.footballmatch.model.eventMatchModel.EventMatch
import nugraha.angga.com.footballmatch.presenter.DetailActivityPresenter
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select
import org.jetbrains.anko.design.snackbar
import org.jetbrains.anko.support.v4.onRefresh
import java.text.SimpleDateFormat

class DetaillActivity:AppCompatActivity(), DetailActivityView {
    private lateinit var detailActivityPresenter: DetailActivityPresenter
    private lateinit var nameHomeClub:String
    private lateinit var nameAwayClub:String
    private var menuItem: Menu? = null
    private var isFavorite: Boolean = false
    private var dataEvent:EventMatch? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity_layout)

        val actionBar = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)


        dataEvent = intent.getSerializableExtra("data") as EventMatch
        favoriteState()

        nameHomeClub = dataEvent?.strHomeTeam.toString()
        nameAwayClub = dataEvent?.strAwayTeam.toString()

        tvTanggal.text = getDateWithServerTimeStamp(dataEvent!!.dateEvent.toString())
        tvNameHomeClub.text = dataEvent?.strHomeTeam
        tvNameAwayClub.text = dataEvent?.strAwayTeam
        if (dataEvent?.intHomeScore.toString() != null){
            tvScoreHome.text = dataEvent?.intHomeScore
        }else{
            tvScoreHome.text = ""
        }

        if (dataEvent?.intAwayScore != null){
            tvScoreAway.text = dataEvent?.intAwayScore
        }else{
            tvScoreAway.text = ""
        }

        tvGoalHomeName.text = dataEvent?.strHomeGoalDetails
        tvGoalAwayName.text = dataEvent?.strAwayGoalDetails
        tvScoreShotHome.text = dataEvent?.intHomeShots
        tvScoreShotAway.text = dataEvent?.intAwayShots
        tvGoalKeeperHome.text = dataEvent?.strHomeLineupGoalkeeper
        tvGoalKeeperAway.text = dataEvent?.strAwayLineupGoalkeeper
        tvDefenseHome.text = dataEvent?.strHomeLineupDefense
        tvDefenseAway.text = dataEvent?.strAwayLineupDefense
        tvMidFieldHome.text = dataEvent?.strHomeLineupMidfield
        tvMidFieldAway.text = dataEvent?.strAwayLineupMidfield
        tvForwardHome.text = dataEvent?.strHomeLineupForward
        tvForwardAway.text = dataEvent?.strAwayLineupForward
        tvSubtitutesHome.text = dataEvent?.strHomeLineupSubstitutes
        tvSubtitutesAway.text = dataEvent?.strAwayLineupSubstitutes

        val compositeDisposable: CompositeDisposable = CompositeDisposable()
        val repository = ServiceSportDBProvider.providerAllTeamLeagueTeamRepository()

        detailActivityPresenter = DetailActivityPresenter(this, compositeDisposable, repository, AndroidSchedulers.mainThread(), Schedulers.io())
        detailActivityPresenter.getAllTeamLeagueList(dataEvent?.idLeague.toString())

        swpDetail.onRefresh {
            detailActivityPresenter.getAllTeamLeagueList(dataEvent?.idLeague.toString())
        }
    }

    private fun addToFavorite(){
        try {
            database.use {
                insert(Favorite.TABLE_FAVORITE,
                        Favorite.ID_EVENT to dataEvent?.idEvent,
                        Favorite.HOME_TEAM_NAME to dataEvent?.strHomeTeam,
                        Favorite.AWAY_TEAM_NAME to dataEvent?.strAwayTeam,
                        Favorite.HOME_TEAM_SCORE to dataEvent?.intHomeScore,
                        Favorite.AWAY_TEAM_SCORE to dataEvent?.intAwayScore,
                        Favorite.HOME_GOAL_DETAIL to dataEvent?.strHomeGoalDetails,
                        Favorite.AWAY_GOAL_DETAIL to dataEvent?.strAwayGoalDetails,
                        Favorite.HOME_SHOTS to dataEvent?.intHomeShots,
                        Favorite.AWAY_SHOTS to dataEvent?.intAwayShots,
                        Favorite.HOME_LINEUP_GOALKEEPER to dataEvent?.strHomeLineupGoalkeeper,
                        Favorite.AWAY_LINEUP_GOALKEEPER to dataEvent?.strAwayLineupGoalkeeper,
                        Favorite.HOME_LINEUP_DEFENSE to dataEvent?.strHomeLineupDefense,
                        Favorite.AWAY_LINEUP_DEFENSE to dataEvent?.strAwayLineupDefense,
                        Favorite.HOME_LINEUP_MIDFIELD to dataEvent?.strHomeLineupMidfield,
                        Favorite.AWAY_LINEUP_MIDFIELD to dataEvent?.strAwayLineupMidfield,
                        Favorite.HOME_LINEUP_FORWARD to dataEvent?.strHomeLineupForward,
                        Favorite.AWAY_LINEUP_FORWARD to dataEvent?.strAwayLineupForward,
                        Favorite.HOME_LINEUP_SUBTITUTES to dataEvent?.strHomeLineupSubstitutes,
                        Favorite.AWAY_LINEUP_SUBTITUTES to dataEvent?.strAwayLineupSubstitutes,
                        Favorite.STR_DATE to dataEvent?.dateEvent)
            }
            snackbar( nested_scroll,R.string.add_favorite).show()
        } catch (e: SQLiteConstraintException){
            snackbar( nested_scroll,e.localizedMessage).show()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }

            R.id.add_to_favorite -> {
                if (isFavorite) removeFromFavorite() else addToFavorite()

                isFavorite = !isFavorite
                setFavorite()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun showLoading() {
        swpDetail.isRefreshing = true
    }

    override fun hideLoading() {
        swpDetail.isRefreshing = false
    }

    override fun showAllteam(dataAllteam: List<Team>?) {

        swpDetail.isRefreshing = false
        if (dataAllteam != null) {
            for (i in dataAllteam.indices){
                if(dataAllteam[i].strTeam.equals(nameHomeClub)){
                    Glide.with(ivImageHomeScore).load(dataAllteam[i].strTeamBadge).into(ivImageHomeScore)
                }

                if(dataAllteam[i].strTeam.equals(nameAwayClub)){
                    Glide.with(ivImageAwayScore).load(dataAllteam[i].strTeamBadge).into(ivImageAwayScore)
                }
            }
        }
    }

    fun getDateWithServerTimeStamp(date:String): String {
        var spf = SimpleDateFormat("yyyy-MM-dd")
        val newDate = spf.parse(date)
        spf = SimpleDateFormat("EEE, d MMM yyyy")
        val dateNewFormat = spf.format(newDate)

        return dateNewFormat.toString()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.detail_menu, menu)
        menuItem = menu
        setFavorite()
        return true
    }

    private fun favoriteState(){
        database.use {
            val result = select(Favorite.TABLE_FAVORITE)
                    .whereArgs("(ID_EVENT = {id})",
                            "id" to dataEvent!!.idEvent.toString())
            val favorite = result.parseList(classParser<Favorite>())
            if (!favorite.isEmpty()) isFavorite = true
        }
    }

    private fun removeFromFavorite(){
        try {
            database.use {
                delete(Favorite.TABLE_FAVORITE, "(ID_EVENT = {id})",
                        "id" to dataEvent!!.idEvent.toString())
            }
            snackbar( nested_scroll,R.string.remove_favorite).show()
        } catch (e: SQLiteConstraintException){
            snackbar( nested_scroll,e.localizedMessage).show()
        }
    }

    private fun setFavorite() {
        if (isFavorite)
            menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this, R.drawable.ic_added_to_favorites)
        else
            menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this, R.drawable.ic_add_to_favorites)
    }

}