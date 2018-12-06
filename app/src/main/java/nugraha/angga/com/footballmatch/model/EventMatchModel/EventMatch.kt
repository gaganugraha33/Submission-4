package nugraha.angga.com.footballmatch.model.eventMatchModel

import java.io.Serializable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class EventMatch : Serializable {

    @SerializedName("idEvent")
    @Expose
    var idEvent: String? = null
    @SerializedName("idSoccerXML")
    @Expose
    var idSoccerXML: String? = null
    @SerializedName("strEvent")
    @Expose
    var strEvent: String? = null
    @SerializedName("strFilename")
    @Expose
    var strFilename: String? = null
    @SerializedName("strSport")
    @Expose
    var strSport: String? = null
    @SerializedName("idLeague")
    @Expose
    var idLeague: String? = null
    @SerializedName("strLeague")
    @Expose
    var strLeague: String? = null
    @SerializedName("strSeason")
    @Expose
    var strSeason: String? = null
    @SerializedName("strDescriptionEN")
    @Expose
    var strDescriptionEN: Any? = null
    @SerializedName("strHomeTeam")
    @Expose
    var strHomeTeam: String? = null
    @SerializedName("strAwayTeam")
    @Expose
    var strAwayTeam: String? = null
    @SerializedName("intHomeScore")
    @Expose
    var intHomeScore: String? = null
    @SerializedName("intRound")
    @Expose
    var intRound: String? = null
    @SerializedName("intAwayScore")
    @Expose
    var intAwayScore: String? = null
    @SerializedName("intSpectators")
    @Expose
    var intSpectators: Any? = null
    @SerializedName("strHomeGoalDetails")
    @Expose
    var strHomeGoalDetails: String? = null
    @SerializedName("strHomeRedCards")
    @Expose
    var strHomeRedCards: String? = null
    @SerializedName("strHomeYellowCards")
    @Expose
    var strHomeYellowCards: String? = null
    @SerializedName("strHomeLineupGoalkeeper")
    @Expose
    var strHomeLineupGoalkeeper: String? = null
    @SerializedName("strHomeLineupDefense")
    @Expose
    var strHomeLineupDefense: String? = null
    @SerializedName("strHomeLineupMidfield")
    @Expose
    var strHomeLineupMidfield: String? = null
    @SerializedName("strHomeLineupForward")
    @Expose
    var strHomeLineupForward: String? = null
    @SerializedName("strHomeLineupSubstitutes")
    @Expose
    var strHomeLineupSubstitutes: String? = null
    @SerializedName("strHomeFormation")
    @Expose
    var strHomeFormation: String? = null
    @SerializedName("strAwayRedCards")
    @Expose
    var strAwayRedCards: String? = null
    @SerializedName("strAwayYellowCards")
    @Expose
    var strAwayYellowCards: String? = null
    @SerializedName("strAwayGoalDetails")
    @Expose
    var strAwayGoalDetails: String? = null
    @SerializedName("strAwayLineupGoalkeeper")
    @Expose
    var strAwayLineupGoalkeeper: String? = null
    @SerializedName("strAwayLineupDefense")
    @Expose
    var strAwayLineupDefense: String? = null
    @SerializedName("strAwayLineupMidfield")
    @Expose
    var strAwayLineupMidfield: String? = null
    @SerializedName("strAwayLineupForward")
    @Expose
    var strAwayLineupForward: String? = null
    @SerializedName("strAwayLineupSubstitutes")
    @Expose
    var strAwayLineupSubstitutes: String? = null
    @SerializedName("strAwayFormation")
    @Expose
    var strAwayFormation: String? = null
    @SerializedName("intHomeShots")
    @Expose
    var intHomeShots: String? = null
    @SerializedName("intAwayShots")
    @Expose
    var intAwayShots: String? = null
    @SerializedName("dateEvent")
    @Expose
    var dateEvent: String? = null
    @SerializedName("strDate")
    @Expose
    var strDate: String? = null
    @SerializedName("strTime")
    @Expose
    var strTime: String? = null
    @SerializedName("strTVStation")
    @Expose
    var strTVStation: Any? = null
    @SerializedName("idHomeTeam")
    @Expose
    var idHomeTeam: String? = null
    @SerializedName("idAwayTeam")
    @Expose
    var idAwayTeam: String? = null
    @SerializedName("strResult")
    @Expose
    var strResult: Any? = null
    @SerializedName("strCircuit")
    @Expose
    var strCircuit: Any? = null
    @SerializedName("strCountry")
    @Expose
    var strCountry: Any? = null
    @SerializedName("strCity")
    @Expose
    var strCity: Any? = null
    @SerializedName("strPoster")
    @Expose
    var strPoster: Any? = null
    @SerializedName("strFanart")
    @Expose
    var strFanart: Any? = null
    @SerializedName("strThumb")
    @Expose
    var strThumb: Any? = null
    @SerializedName("strBanner")
    @Expose
    var strBanner: Any? = null
    @SerializedName("strMap")
    @Expose
    var strMap: Any? = null
    @SerializedName("strLocked")
    @Expose
    var strLocked: String? = null

    companion object {
        private const val serialVersionUID = -7206717147339112848L
    }

}
