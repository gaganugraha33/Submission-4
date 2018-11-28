package nugraha.angga.com.footballmatch.view
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.match_layout.*
import kotlinx.android.synthetic.main.overview_layout.*
import nugraha.angga.com.footballmatch.R
import nugraha.angga.com.footballmatch.`interface`.MatchFragmentView
import nugraha.angga.com.footballmatch.adapter.MatchAdapter
import nugraha.angga.com.footballmatch.api.ServiceSportDBProvider
import nugraha.angga.com.footballmatch.model.eventMatchModel.EventMatch
import nugraha.angga.com.footballmatch.presenter.MatchFragmentPresenter
import org.jetbrains.anko.support.v4.onRefresh
import java.io.Serializable

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