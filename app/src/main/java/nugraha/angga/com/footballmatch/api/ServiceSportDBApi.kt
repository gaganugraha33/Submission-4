package nugraha.angga.com.footballmatch.api

import io.reactivex.Observable
import nugraha.angga.com.footballmatch.model.allLeagueModel.AllLeague
import nugraha.angga.com.footballmatch.model.allTeamLeagueModel.AllTeamLeague
import nugraha.angga.com.footballmatch.model.eventMatchModel.MatchFootbal
import nugraha.angga.com.footballmatch.model.eventMatchModel.MatchFootbalSearch
import nugraha.angga.com.footballmatch.model.playerModel.PlayerData
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceSportDBApi {

    @GET("/api/v1/json/1/eventspastleague.php")
    fun getLastMatch(@Query("id") code_league: String): Observable<MatchFootbal>

    @GET("/api/v1/json/1/eventsnextleague.php")
    fun getNextMatch(@Query("id") code_league: String): Observable<MatchFootbal>

    @GET("/api/v1/json/1/searchevents.php")
    fun getSearchEvent(@Query("e") match: String): Observable<MatchFootbalSearch>

    @GET("/api/v1/json/1/lookup_all_teams.php")
    fun getAllTeamLeague(@Query("id") code_league: String): Observable<AllTeamLeague>

    @GET("/api/v1/json/1/searchteams.php")
    fun getSearchTeamLeague(@Query("t") name_team: String): Observable<AllTeamLeague>

    @GET("/api/v1/json/1/searchplayers.php")
    fun getPlayerList(@Query("t") nameClub: String): Observable<PlayerData>

    @GET("/api/v1/json/1/all_leagues.php")
    fun getAllLeague(): Observable<AllLeague>

    companion object Factory {
        fun create(): ServiceSportDBApi {
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://www.thesportsdb.com")
                    .build()

            return retrofit.create(ServiceSportDBApi::class.java)
        }
    }

}