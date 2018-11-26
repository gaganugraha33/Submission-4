package nugraha.angga.com.footballmatch.view
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.ActionBar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.match_layout.*
import kotlinx.android.synthetic.main.matches_layout.*
import nugraha.angga.com.footballmatch.R
import nugraha.angga.com.footballmatch.adapter.MyPageAdapter
import org.jetbrains.anko.support.v4.onRefresh


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

        tabs_main.setupWithViewPager(viewpager_main)
    }

}