package nugraha.angga.com.footballmatch.view
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.match_layout.*
import nugraha.angga.com.footballmatch.R
import nugraha.angga.com.footballmatch.`interface`.MatchFragmentView
import nugraha.angga.com.footballmatch.adapter.MatchAdapter
import nugraha.angga.com.footballmatch.api.ServiceSportDBProvider
import nugraha.angga.com.footballmatch.model.EventMatchModel.EventMatch
import nugraha.angga.com.footballmatch.presenter.MatchFragmentPresenter
import org.jetbrains.anko.support.v4.onRefresh
import java.io.Serializable

class NextMatchFragment :Fragment(), MatchFragmentView {



    private lateinit var matchfragmentPresenter:MatchFragmentPresenter
    private lateinit var matchAdapter: MatchAdapter
    private var nextMatch:MutableList<EventMatch> = mutableListOf()



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.match_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvMatch.layoutManager = LinearLayoutManager(context)
        matchAdapter = MatchAdapter(nextMatch){
            val intentDetail = Intent(context, DetaillActivity::class.java)
            intentDetail.putExtra("data", it as Serializable)
            startActivity(intentDetail)
        }
        rvMatch.adapter = matchAdapter

        val compositeDisposable: CompositeDisposable = CompositeDisposable()
        val repository = ServiceSportDBProvider.providerNextMatchRepository()

        matchfragmentPresenter = MatchFragmentPresenter(this, compositeDisposable, repository)
        matchfragmentPresenter.getNextMatchList()


        swpLayout.onRefresh {
            matchfragmentPresenter.getNextMatchList()
        }
    }

    override fun showLoading() {
      swpLayout.isRefreshing = true
    }

    override fun hideLoading() {
        swpLayout.isRefreshing = false
    }

    override fun showMatchList(data: List<EventMatch>?) {
        println("isi datana bosque ${data!!.size}")
        swpLayout.isRefreshing = false
        nextMatch.clear()
        nextMatch.addAll(data)
        matchAdapter.notifyDataSetChanged()
    }


}