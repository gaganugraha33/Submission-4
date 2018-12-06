package nugraha.angga.com.footballmatch.menumatches
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.matches_layout.*
import nugraha.angga.com.footballmatch.R
import nugraha.angga.com.footballmatch.menumatches.adapter.MyPageAdapter



class MatchesFragment:Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.matches_layout, container, false)

    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        createdViewPager()
    }


    fun createdViewPager(){
        val myPageAdapter = MyPageAdapter(childFragmentManager)
        viewpager_main.adapter = myPageAdapter
        viewpager_main.addOnPageChangeListener(
                TabLayout.TabLayoutOnPageChangeListener(tabs_main))
        tabs_main.setupWithViewPager(viewpager_main)

        tabs_main.addOnTabSelectedListener(object :
                TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewpager_main.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }

        })
    }

}