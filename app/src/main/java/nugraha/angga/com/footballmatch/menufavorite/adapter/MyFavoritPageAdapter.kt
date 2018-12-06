package nugraha.angga.com.footballmatch.menufavorite.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.PagerAdapter
import nugraha.angga.com.footballmatch.menufavorite.menufavoritematch.FavoriteFragment
import nugraha.angga.com.footballmatch.menumatches.NextMatchFragment
import nugraha.angga.com.footballmatch.menufavorite.menufavoriteteam.TeamsFavoriteFragment

class MyFavoritPageAdapter(fm:FragmentManager):FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                FavoriteFragment()
            }
            1 -> TeamsFavoriteFragment()
            else -> {
                return NextMatchFragment()
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
            0 -> "Matches"
            1 -> "Team"
            else -> {
                return "Team"
            }
        }
    }
}