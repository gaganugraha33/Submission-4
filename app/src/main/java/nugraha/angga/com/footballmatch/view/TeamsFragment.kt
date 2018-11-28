package nugraha.angga.com.footballmatch.view
import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.widget.SearchView;
import android.view.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.match_layout.*
import nugraha.angga.com.footballmatch.R
import nugraha.angga.com.footballmatch.`interface`.AllTeamFragmentView
import nugraha.angga.com.footballmatch.adapter.AllTeamAdapter
import nugraha.angga.com.footballmatch.api.ServiceSportDBProvider
import nugraha.angga.com.footballmatch.model.allTeamLeagueModel.Team
import nugraha.angga.com.footballmatch.presenter.TeamFragmentPresenter
import org.jetbrains.anko.support.v4.onRefresh
import android.widget.AdapterView
import android.widget.ArrayAdapter
import nugraha.angga.com.footballmatch.model.allLeagueModel.League
import java.io.Serializable


class TeamsFragment :Fragment(), AllTeamFragmentView, AdapterView.OnItemSelectedListener{
    private lateinit var teamFragmentPresenter: TeamFragmentPresenter
    private lateinit var allTeamAdapter: AllTeamAdapter
    private lateinit var codeLeagueName: String
    private var allTeamList:MutableList<Team> = mutableListOf()
    private var allLeagueList:MutableList<League> = mutableListOf()
    var list_of_items:ArrayList<String> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.match_layout, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvMatch.layoutManager = LinearLayoutManager(context)
        codeLeagueName = "4328"


        allTeamAdapter = AllTeamAdapter(allTeamList){
            val intentDetail = Intent(context, TeamDetailActivity::class.java)
            intentDetail.putExtra("data", it as Serializable)
            startActivity(intentDetail)
        }
        rvMatch.adapter = allTeamAdapter

        val compositeDisposable: CompositeDisposable = CompositeDisposable()
        val repository = ServiceSportDBProvider.providerTeamRepository()

        teamFragmentPresenter = TeamFragmentPresenter(this, compositeDisposable, repository, AndroidSchedulers.mainThread(),Schedulers.io())
        teamFragmentPresenter.getAllLeague()



        swpLayout.onRefresh {
            teamFragmentPresenter.getAllLeague()
            teamFragmentPresenter.getAllTeamList(codeLeagueName)
        }
    }

    override fun showLoading() {
      swpLayout.isRefreshing = true
    }

    override fun hideLoading() {
        swpLayout.isRefreshing = false
    }

    override fun showListAllTeam(data: List<Team>?) {
        swpLayout.isRefreshing = false
        allTeamList.clear()
        data?.let { allTeamList.addAll(it) }
        allTeamAdapter.notifyDataSetChanged()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
        if (list_of_items != null) {
               if (list_of_items[position].equals(allLeagueList[position].strLeague.toString())){
                   teamFragmentPresenter.getAllTeamList(allLeagueList[position].idLeague.toString())
                   codeLeagueName = list_of_items[position]
               }

        }
    }

    override fun showListAllLeague(data: List<League>?) {
        swpLayout.isRefreshing = false
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
        spinner_teams.setAdapter(adapterSpinner)

        spinner_teams.setOnItemSelectedListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        activity?.menuInflater?.inflate(R.menu.menu_search, menu)
        val searchItem = menu?.findItem(R.id.action_search)
        val searchView = searchItem?.getActionView() as SearchView
        searchView.queryHint = "Find Team"
        val searchManager = activity?.getSystemService(Context.SEARCH_SERVICE) as SearchManager
        searchView.setSearchableInfo(searchManager
                .getSearchableInfo(activity!!.componentName))

        val queryTextListener = object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                if (query.equals("")){
                    spinner_teams.visibility  = View.VISIBLE
                    teamFragmentPresenter.getAllLeague()
                    teamFragmentPresenter.getAllTeamList(codeLeagueName)
                }else{
                    spinner_teams.visibility  = View.GONE
                    teamFragmentPresenter.getSearchTeamList(query)
                }
                searchView.clearFocus()
                return true
            }

            override fun onQueryTextChange(query: String): Boolean {
                if (query.equals("")){
                    spinner_teams.visibility  = View.VISIBLE
                    teamFragmentPresenter.getAllLeague()
                    teamFragmentPresenter.getAllTeamList(codeLeagueName)
                }else{
                    spinner_teams.visibility  = View.GONE
                    teamFragmentPresenter.getSearchTeamList(query)
                }
                return true
            }
        }
        searchView.setOnQueryTextListener(queryTextListener)
    }

}