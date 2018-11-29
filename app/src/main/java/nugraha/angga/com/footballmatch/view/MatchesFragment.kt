package nugraha.angga.com.footballmatch.view
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.matches_layout.*
import nugraha.angga.com.footballmatch.R
import nugraha.angga.com.footballmatch.adapter.MyPageAdapter



class MatchesFragment:Fragment(){
    companion object{
        private lateinit var supportFragmentManagerMatches:FragmentManager

        fun newInstance(supportFragmentManager:FragmentManager): MatchesFragment {
            val fragment = MatchesFragment()
            supportFragmentManagerMatches = supportFragmentManager
            return fragment
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.matches_layout, container, false)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createdViewPager()
    }


    fun createdViewPager(){
        println("test testtt steeee")
        val myPageAdapter = MyPageAdapter(supportFragmentManagerMatches)
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