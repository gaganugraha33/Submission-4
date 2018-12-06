package nugraha.angga.com.footballmatch.menufavorite
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.view.*
import kotlinx.android.synthetic.main.matches_layout.*
import nugraha.angga.com.footballmatch.R
import nugraha.angga.com.footballmatch.menufavorite.adapter.MyFavoritPageAdapter



class AllFavoriteFragment:Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.matches_layout, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        createdViewPager()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }


    fun createdViewPager(){
        val myFavoritPageAdapter = MyFavoritPageAdapter(childFragmentManager)
        viewpager_main.adapter = myFavoritPageAdapter
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

    override fun onPrepareOptionsMenu(menu: Menu?) {
        super.onPrepareOptionsMenu(menu)
        val item = menu?.findItem(R.id.action_search)
        item?.setVisible(false)
    }


}