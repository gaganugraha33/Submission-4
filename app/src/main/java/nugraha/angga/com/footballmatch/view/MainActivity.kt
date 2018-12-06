package nugraha.angga.com.footballmatch.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import nugraha.angga.com.footballmatch.R
import nugraha.angga.com.footballmatch.menufavorite.AllFavoriteFragment
import nugraha.angga.com.footballmatch.menumatches.MatchesFragment
import nugraha.angga.com.footballmatch.menuteam.TeamsFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionBar = supportActionBar
        actionBar?.elevation = 0F

        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.prev_match -> {
                    loadMatchesFragment(savedInstanceState)
                }
                R.id.next_match  -> {
                    loadTeamFragment(savedInstanceState)
                }

                R.id.favorites  -> {
                    loadFavoriteFragment(savedInstanceState)
                }
            }
            true
        }
        bottom_navigation.selectedItemId = R.id.prev_match
    }

    private fun loadMatchesFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_container, MatchesFragment(), MatchesFragment::class.java.simpleName)
                    .commit()
        }
    }

    private fun loadTeamFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_container, TeamsFragment(), TeamsFragment::class.java.simpleName)
                    .commit()
        }
    }

    private fun loadFavoriteFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_container, AllFavoriteFragment(), AllFavoriteFragment::class.java.simpleName)
                    .commit()
        }
    }
}
