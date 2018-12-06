package nugraha.angga.com.footballmatch.menudetailteam

import android.database.sqlite.SQLiteConstraintException
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.team_detail_activity_layout.*
import nugraha.angga.com.footballmatch.R
import nugraha.angga.com.footballmatch.menudetailteam.adapter.TeamPageAdapter
import nugraha.angga.com.footballmatch.db.TeamFavorite
import nugraha.angga.com.footballmatch.db.databaseTeam
import nugraha.angga.com.footballmatch.model.allTeamLeagueModel.Team
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select
import org.jetbrains.anko.design.snackbar

class TeamDetailActivity :AppCompatActivity() {
    private var menuItem: Menu? = null
    private var dataTeam:Team? = null
    private var isFavorite: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.team_detail_activity_layout)

        dataTeam = intent.getSerializableExtra("data") as Team
        favoriteState()
        tvYears.text = dataTeam?.intFormedYear.toString()
        tvHome.text = dataTeam?.strStadium.toString()
        tvNameClub.text = dataTeam?.strTeam.toString()
        Glide.with(expandedImage).load(dataTeam?.strTeamBadge.toString()).into(expandedImage)

        setSupportActionBar(toolbar_team)
        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val teamPageAdapter = TeamPageAdapter(supportFragmentManager, dataTeam?.strDescriptionEN.toString(), dataTeam?.strTeam.toString())
        htab_viewpager.adapter = teamPageAdapter

        htab_tabs.setupWithViewPager(htab_viewpager)
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

    private fun removeFromFavorite(){
        try {
            databaseTeam.use {
                delete(TeamFavorite.TABLE_FAVORITE, "(ID_TEAM = {id})",
                        "id" to dataTeam?.idTeam.toString())
            }
            snackbar( htab_viewpager,R.string.remove_favorite).show()
        } catch (e: SQLiteConstraintException){
            snackbar( htab_viewpager,e.localizedMessage).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.detail_menu, menu)
        menuItem = menu
        setFavorite()
        return true
    }

    private fun addToFavorite(){
        try {
            databaseTeam.use {
                insert(TeamFavorite.TABLE_FAVORITE,
                        TeamFavorite.ID_TEAM to dataTeam?.idTeam,
                        TeamFavorite.STR_TEAM to dataTeam?.strTeam,
                        TeamFavorite.STR_TEAM_BADGE to dataTeam?.strTeamBadge,
                        TeamFavorite.INT_FORMED_YEAR to dataTeam?.intFormedYear.toString(),
                        TeamFavorite.STR_STADIUM to dataTeam?.strStadium,
                        TeamFavorite.STR_DESCRIPTION_EN to dataTeam?.strDescriptionEN)
            }
            snackbar( htab_viewpager,R.string.add_favorite).show()
        } catch (e: SQLiteConstraintException){
            snackbar( htab_viewpager,e.localizedMessage).show()
        }
    }

    private fun setFavorite() {
        if (isFavorite)
            menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this, R.drawable.ic_added_to_favorites)
        else
            menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this, R.drawable.ic_add_to_favorites)
    }

    private fun favoriteState(){
        databaseTeam.use {
            val result = select(TeamFavorite.TABLE_FAVORITE)
                    .whereArgs("(ID_TEAM = {id})",
                            "id" to dataTeam?.idTeam.toString())
            val favorite = result.parseList(classParser<TeamFavorite>())
            if (!favorite.isEmpty()) isFavorite = true
        }
    }
}