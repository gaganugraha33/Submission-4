package nugraha.angga.com.footballmatch.api

import io.reactivex.Observable
import nugraha.angga.com.footballmatch.model.allLeagueModel.AllLeague
import nugraha.angga.com.footballmatch.model.allTeamLeagueModel.AllTeamLeague
import nugraha.angga.com.footballmatch.model.eventMatchModel.MatchFootbal

class SportDBRepository(val apiService:ServiceSportDBApi) {

    fun lastMatchReq():Observable<MatchFootbal>{
        return apiService.getLastMatch()
    }

    fun nextMatchReq():Observable<MatchFootbal>{
        return apiService.getNextMatch()
    }

    fun allTeamReq(codeLeague:String):Observable<AllTeamLeague>{
        return apiService.getAllTeamLeague(codeLeague)
    }

    fun allTeamSearchReq(name_team:String):Observable<AllTeamLeague>{
        return apiService.getSearchTeamLeague(name_team)
    }

    fun allLeague():Observable<AllLeague>{
        return apiService.getAllLeague()
    }

}