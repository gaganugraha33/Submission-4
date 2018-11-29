package nugraha.angga.com.footballmatch.view
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.overview_layout.*
import nugraha.angga.com.footballmatch.R

class OverviewFragment :Fragment() {

    companion object{
        private var strTeam:String? = null

        fun newInstance(strDescTeam:String): OverviewFragment {
            strTeam = strDescTeam
            val fragment = OverviewFragment()
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.overview_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvDesc.text = strTeam
    }

}