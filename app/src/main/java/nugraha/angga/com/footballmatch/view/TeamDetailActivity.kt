package nugraha.angga.com.footballmatch.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.detail_activity_layout.*
import kotlinx.android.synthetic.main.team_detail_activity_layout.*
import nugraha.angga.com.footballmatch.R
import nugraha.angga.com.footballmatch.adapter.TeamPageAdapter
import nugraha.angga.com.footballmatch.model.allTeamLeagueModel.Team

class TeamDetailActivity :AppCompatActivity() {
    private var menuItem: Menu? = null
    private var dataTeam:Team? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.team_detail_activity_layout)

        dataTeam = intent.getSerializableExtra("data") as Team
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
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.detail_menu, menu)
        menuItem = menu
        return true
    }
}