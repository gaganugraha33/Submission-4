package nugraha.angga.com.footballmatch.menumatches
import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.*
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SearchView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.match_layout_next.*
import nugraha.angga.com.footballmatch.R
import nugraha.angga.com.footballmatch.menumatches.view.MatchFragmentView
import nugraha.angga.com.footballmatch.menumatches.adapter.MatchAdapter
import nugraha.angga.com.footballmatch.api.ServiceSportDBProvider
import nugraha.angga.com.footballmatch.model.allLeagueModel.League
import nugraha.angga.com.footballmatch.model.eventMatchModel.EventMatch
import nugraha.angga.com.footballmatch.menumatches.presenter.MatchFragmentPresenter
import nugraha.angga.com.footballmatch.menudetailmatch.DetaillActivity
import org.jetbrains.anko.support.v4.onRefresh
import java.io.Serializable

class NextMatchFragment :Fragment(), MatchFragmentView, AdapterView.OnItemSelectedListener{
    private var allLeagueList:MutableList<League> = mutableListOf()
    private lateinit var codeLeagueName: String
    private lateinit var matchfragmentPresenter: MatchFragmentPresenter
    private lateinit var matchAdapter: MatchAdapter
    private var nextMatch:MutableList<EventMatch> = mutableListOf()
    var listofitems:ArrayList<String> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.match_layout_next, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        codeLeagueName = "4328"
        rvMatchNext.layoutManager = LinearLayoutManager(context)
        matchAdapter = MatchAdapter(nextMatch, context!!.getString(R.string.type_next_match), context!!) {
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
        listofitems.clear()
        data?.let { allLeagueList.addAll(it) }

        if (data != null) {
            for (i in data.indices){
                listofitems.add(data[i].strLeague.toString())
            }
        }

        val adapterSpinner = ArrayAdapter(context, android.R.layout.simple_spinner_item, listofitems)
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner_teams_next.setAdapter(adapterSpinner)

        spinner_teams_next.setOnItemSelectedListener(this)

    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
        if (listofitems != null) {
            if (listofitems[position].equals(allLeagueList[position].strLeague.toString())){
                matchfragmentPresenter.getNextMatchList(allLeagueList[position].idLeague.toString())
                codeLeagueName = listofitems[position]
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