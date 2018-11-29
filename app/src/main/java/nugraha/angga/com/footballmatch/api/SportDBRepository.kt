package nugraha.angga.com.footballmatch.api

import io.reactivex.Observable
import nugraha.angga.com.footballmatch.model.allLeagueModel.AllLeague
import nugraha.angga.com.footballmatch.model.allTeamLeagueModel.AllTeamLeague
import nugraha.angga.com.footballmatch.model.eventMatchModel.MatchFootbal
import nugraha.angga.com.footballmatch.model.eventMatchModel.MatchFootbalSearch
import nugraha.angga.com.footballmatch.model.playerModel.PlayerData

class SportDBRepository(val apiService:ServiceSportDBApi) {

    fun lastMatchReq(codeLeague: String):Observable<MatchFootbal>{
        return apiService.getLastMatch(codeLeague)
    }

    fun nextMatchReq(codeLeague: String):Observable<MatchFootbal>{
        return apiService.getNextMatch(codeLeague)
    }

    fun searchEvent(match:String):Observable<MatchFootbalSearch>{
        return apiService.getSearchEvent(match)
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

    fun allPlayer(nameClub:String):Observable<PlayerData>{
        return apiService.getPlayerList(nameClub)
    }



}