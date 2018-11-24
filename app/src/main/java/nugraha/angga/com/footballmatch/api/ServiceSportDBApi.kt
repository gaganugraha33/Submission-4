package nugraha.angga.com.footballmatch.api

import io.reactivex.Observable
import nugraha.angga.com.footballmatch.model.allTeamLeagueModel.AllTeamLeague
import nugraha.angga.com.footballmatch.model.eventMatchModel.MatchFootbal
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceSportDBApi {

    @GET("/api/v1/json/1/eventspastleague.php")
    fun getLastMatch(@Query("id") code_league: String = "4331"): Observable<MatchFootbal>

    @GET("/api/v1/json/1/eventsnextleague.php")
    fun getNextMatch(@Query("id") code_league: String = "4331"): Observable<MatchFootbal>

    @GET("/api/v1/json/1/lookup_all_teams.php")
    fun getAllTeamLeague(@Query("id") code_league: String = "4331"): Observable<AllTeamLeague>

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