package nugraha.angga.com.footballmatch.view
import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.*
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SearchView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.match_layout.*
import kotlinx.android.synthetic.main.match_layout_next.*
import nugraha.angga.com.footballmatch.R
import nugraha.angga.com.footballmatch.`interface`.MatchFragmentView
import nugraha.angga.com.footballmatch.adapter.MatchAdapter
import nugraha.angga.com.footballmatch.api.ServiceSportDBProvider
import nugraha.angga.com.footballmatch.model.allLeagueModel.League
import nugraha.angga.com.footballmatch.model.eventMatchModel.EventMatch
import nugraha.angga.com.footballmatch.presenter.MatchFragmentPresenter
import org.jetbrains.anko.support.v4.onRefresh
import java.io.Serializable

class NextMatchFragment :Fragment(), MatchFragmentView, AdapterView.OnItemSelectedListener{
    private var allLeagueList:MutableList<League> = mutableListOf()
    private lateinit var codeLeagueName: String
    private lateinit var matchfragmentPresenter:MatchFragmentPresenter
    private lateinit var matchAdapter: MatchAdapter
    private var nextMatch:MutableList<EventMatch> = mutableListOf()
    var list_of_items:ArrayList<String> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.match_layout_next, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        codeLeagueName = "4328"
        rvMatchNext.layoutManager = LinearLayoutManager(context)
        matchAdapter = MatchAdapter(nextMatch, context!!.getString(R.string.type_next_match), context!!){
            val intentDetail = Intent(context, DetaillActivity::class.java)
            intentDetail.putExtra("data", it as Serializable)
            startActivity(intentDetail)
        }
        rvMatchNext.adapter = matchAdapter

        val compositeDisposable: CompositeDisposable = CompositeDisposable()
        val repository = ServiceSportDBProvider.providerNextMatchRepository()

        matchfragmentPresenter = MatchFragmentPresenter(this, compositeDisposable, repository, AndroidSchedulers.mainThread(), Schedulers.io())
        matchfragmentPresenter.getAllLeague()


        swpLayoutNext.onRefresh {
            matchfragmentPresenter.getAllLeague()
            matchfragmentPresenter.getNextMatchList(codeLeagueName)
        }
    }

    override fun showLoading() {
        swpLayoutNext.isRefreshing = true
    }

    override fun hideLoading() {
        swpLayoutNext.isRefreshing = false
    }

    override fun showMatchList(data: List<EventMatch>?) {
        swpLayoutNext.isRefreshing = false
        nextMatch.clear()
        if (data != null) {
            for (i in data.indices){
                if (data[i].intAwayScore == null || data[i].intAwayScore.toString().equals("") || data[i].intAwayScore.toString().equals("null")){
                    nextMatch.add(data[i])
                }
            }
        }
        matchAdapter.notifyDataSetChanged()
    }

    override fun showListAllLeague(data: List<League>?) {

        swpLayoutNext.isRefreshing = false
        allLeagueList.clear()
        list_of_items.clear()
        data?.let { allLeagueList.addAll(it) }

        if (data != null) {
            for (i in data.indices){
                list_of_items.add(data[i].strLeague.toString())
            }
        }

        var adapterSpinner = ArrayAdapter(context, android.R.layout.simple_spinner_item, list_of_items)
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner_teams_next.setAdapter(adapterSpinner)

        spinner_teams_next.setOnItemSelectedListener(this)

    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
        if (list_of_items != null) {
            if (list_of_items[position].equals(allLeagueList[position].strLeague.toString())){
                matchfragmentPresenter.getNextMatchList(allLeagueList[position].idLeague.toString())
                codeLeagueName = list_of_items[position]
            }

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        menu?.clear()
        activity?.menuInflater?.inflate(R.menu.menu_search, menu)
        val searchItem = menu?.findItem(R.id.action_search)
        val searchView = searchItem?.getActionView() as SearchView
        searchView.queryHint = "Find Match"
        val searchManager = activity?.getSystemService(Context.SEARCH_SERVICE) as SearchManager
        searchView.setSearchableInfo(searchManager
                .getSearchableInfo(activity!!.componentName))

        val queryTextListener = object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                if (query.equals("")){
                    spinner_teams_next.visibility  = View.VISIBLE
                    matchfragmentPresenter.getAllLeague()
                    matchfragmentPresenter.getNextMatchList(codeLeagueName)
                }else{
                    spinner_teams_next.visibility  = View.GONE
                    matchfragmentPresenter.getSearchMatchList(query)
                }
                searchView.clearFocus()
                return true
            }

            override fun onQueryTextChange(query: String): Boolean {
                if (query.equals("")){
                    spinner_teams_next.visibility  = View.VISIBLE
                    matchfragmentPresenter.getAllLeague()
                    matchfragmentPresenter.getNextMatchList(codeLeagueName)
                }else{
                    spinner_teams_next.visibility  = View.GONE
                    matchfragmentPresenter.getSearchMatchList(query)
                }
                return true
            }
        }
        searchView.setOnQueryTextListener(queryTextListener)
    }


}