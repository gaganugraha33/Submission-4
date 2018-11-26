package nugraha.angga.com.footballmatch.view
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


class TeamsFragment :Fragment(), AllTeamFragmentView, AdapterView.OnItemSelectedListener {



    private lateinit var teamFragmentPresenter: TeamFragmentPresenter
    private lateinit var allTeamAdapter: AllTeamAdapter
    private var allTeamList:MutableList<Team> = mutableListOf()
    private var allLeagueList:MutableList<League> = mutableListOf()
    var list_of_items:ArrayList<String> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.match_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvMatch.layoutManager = LinearLayoutManager(context)



        allTeamAdapter = AllTeamAdapter(allTeamList){
//            val intentDetail = Intent(context, DetaillActivity::class.java)
//            intentDetail.putExtra("data", it as Serializable)
//            startActivity(intentDetail)
        }
        rvMatch.adapter = allTeamAdapter

        val compositeDisposable: CompositeDisposable = CompositeDisposable()
        val repository = ServiceSportDBProvider.providerLastMatchRepository()

        teamFragmentPresenter = TeamFragmentPresenter(this, compositeDisposable, repository, AndroidSchedulers.mainThread(),Schedulers.io())
        teamFragmentPresenter.getAllTeamList()
        teamFragmentPresenter.getAllLeague()


        swpLayout.onRefresh {
            teamFragmentPresenter.getAllLeague()
            teamFragmentPresenter.getAllTeamList()
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
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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
    }

}