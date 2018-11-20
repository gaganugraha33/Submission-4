package nugraha.angga.com.footballmatch.view

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.match_layout.*
import nugraha.angga.com.footballmatch.R
import nugraha.angga.com.footballmatch.`interface`.FavoriteFragmentView
import nugraha.angga.com.footballmatch.adapter.MatchAdapter
import nugraha.angga.com.footballmatch.db.Favorite
import nugraha.angga.com.footballmatch.model.EventMatchModel.EventMatch
import nugraha.angga.com.footballmatch.presenter.FavoriteFragmentPresenter
import org.jetbrains.anko.support.v4.onRefresh
import java.io.Serializable

class FavoriteFragment : Fragment(), FavoriteFragmentView {
    private lateinit var favoriteFragmentPresenter: FavoriteFragmentPresenter
    private lateinit var matchAdapter: MatchAdapter
    private var favorites: MutableList<EventMatch> = mutableListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.match_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvMatch.layoutManager = LinearLayoutManager(context)
        matchAdapter = MatchAdapter(favorites){
            val intentDetail = Intent(context, DetaillActivity::class.java)
            intentDetail.putExtra("data", it as Serializable)
            startActivity(intentDetail)
        }
        rvMatch.adapter = matchAdapter


        favoriteFragmentPresenter = FavoriteFragmentPresenter(this, context)
        favoriteFragmentPresenter.getFavorite()


        swpLayout.onRefresh {
            favoriteFragmentPresenter.getFavorite()
        }
    }


    override fun showLoading() {
        swpLayout.isRefreshing = true
    }

    override fun hideLoading() {
        swpLayout.isRefreshing = false
    }

    override fun showAllFavorite(dataFavorite: List<Favorite>?) {
        swpLayout.isRefreshing = false
        favorites.clear()

        for (i in dataFavorite!!.indices){
//            favorites.add(dataFavorite.get(i) as EventMatch)
            var eventMatch = EventMatch()
            eventMatch.idEvent = dataFavorite.get(i).idEvent
            eventMatch.intAwayScore = dataFavorite.get(i).intAwayScore
            eventMatch.intHomeScore = dataFavorite.get(i).intHomeScore
            eventMatch.intHomeShots = dataFavorite.get(i).intHomeShots
            eventMatch.intAwayShots = dataFavorite.get(i).intAwayShots
            eventMatch.strAwayGoalDetails = dataFavorite.get(i).strAwayGoalDetails
            eventMatch.strHomeGoalDetails = dataFavorite.get(i).strHomeGoalDetails
            eventMatch.strHomeLineupDefense = dataFavorite.get(i).strHomeLineupDefense
            eventMatch.strAwayLineupDefense = dataFavorite.get(i).strAwayLineupDefense
            eventMatch.strAwayLineupForward = dataFavorite.get(i).strAwayLineupForward
            eventMatch.strHomeLineupForward = dataFavorite.get(i).strHomeLineupForward
            eventMatch.strHomeLineupGoalkeeper = dataFavorite.get(i).strHomeLineupGoalkeeper
            eventMatch.strAwayLineupGoalkeeper = dataFavorite.get(i).strAwayLineupGoalkeeper
            eventMatch.strAwayLineupMidfield = dataFavorite.get(i).strAwayLineupMidfield
            eventMatch.strHomeLineupMidfield = dataFavorite.get(i).strHomeLineupMidfield
            eventMatch.strHomeLineupSubstitutes = dataFavorite.get(i).strHomeLineupSubstitutes
            eventMatch.strAwayLineupSubstitutes = dataFavorite.get(i).strAwayLineupSubstitutes
            eventMatch.strHomeTeam = dataFavorite.get(i).strHomeTeam
            eventMatch.strAwayTeam = dataFavorite.get(i).strAwayTeam
            eventMatch.dateEvent = dataFavorite.get(i).strDate

            favorites.add(eventMatch)
        }

        matchAdapter.notifyDataSetChanged()
    }

    override fun onResume() {
        super.onResume()
        favoriteFragmentPresenter.getFavorite()
    }
}