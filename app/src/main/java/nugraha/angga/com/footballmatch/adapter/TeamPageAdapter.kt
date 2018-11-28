package nugraha.angga.com.footballmatch.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.PagerAdapter
import nugraha.angga.com.footballmatch.view.OverviewFragment
import nugraha.angga.com.footballmatch.view.PlayerFragment
import nugraha.angga.com.footballmatch.view.TeamsFragment

class TeamPageAdapter(fm:FragmentManager, var descTeam:String, var namaClub:String):FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                OverviewFragment.newInstance(descTeam)
            }
            1 -> PlayerFragment.newInstance(namaClub)
            else -> {
                return PlayerFragment.newInstance(namaClub)
            }
        }
    }

    override fun getCount(): Int {
       return 2
    }

    override fun getItemPosition(`object`: Any): Int {
        return PagerAdapter.POSITION_NONE
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "Overview"
            1 -> "Player"
            else -> {
                return "Overview"
            }
        }
    }
}