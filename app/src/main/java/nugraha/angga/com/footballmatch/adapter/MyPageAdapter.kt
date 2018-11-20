package nugraha.angga.com.footballmatch.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import nugraha.angga.com.footballmatch.view.LastMatchFragment
import nugraha.angga.com.footballmatch.view.NextMatchFragment

class MyPageAdapter(fm:FragmentManager):FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                LastMatchFragment()
            }
            1 -> NextMatchFragment()
            else -> {
                return NextMatchFragment()
            }
        }
    }

    override fun getCount(): Int {
       return 2
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "Last Match"
            1 -> "Next Match"
            else -> {
                return "Next Match"
            }
        }
    }
}