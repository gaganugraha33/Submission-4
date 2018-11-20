package nugraha.angga.com.footballmatch.model.EventMatchModel

import java.io.Serializable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class EventMatch : Serializable {

    @SerializedName("idEvent")
    @Expose
    var idEvent: String? = null
        get() = field
        set(value) {
            field = value
        }
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
        get() = field
        set(value) {
            field = value
        }
    @SerializedName("strAwayTeam")
    @Expose
    var strAwayTeam: String? = null
        get() = field
        set(value) {
            field = value
        }
    @SerializedName("intHomeScore")
    @Expose
    var intHomeScore: String? = null
        get() = field
        set(value) {
            field = value
        }
    @SerializedName("intRound")
    @Expose
    var intRound: String? = null
    @SerializedName("intAwayScore")
    @Expose
    var intAwayScore: String? = null
        get() = field
        set(value) {
            field = value
        }
    @SerializedName("intSpectators")
    @Expose
    var intSpectators: Any? = null
    @SerializedName("strHomeGoalDetails")
    @Expose
    var strHomeGoalDetails: String? = null
        get() = field
        set(value) {
            field = value
        }
    @SerializedName("strHomeRedCards")
    @Expose
    var strHomeRedCards: String? = null
    @SerializedName("strHomeYellowCards")
    @Expose
    var strHomeYellowCards: String? = null
    @SerializedName("strHomeLineupGoalkeeper")
    @Expose
    var strHomeLineupGoalkeeper: String? = null
        get() = field
        set(value) {
            field = value
        }
    @SerializedName("strHomeLineupDefense")
    @Expose
    var strHomeLineupDefense: String? = null
        get() = field
        set(value) {
            field = value
        }
    @SerializedName("strHomeLineupMidfield")
    @Expose
    var strHomeLineupMidfield: String? = null
        get() = field
        set(value) {
            field = value
        }
    @SerializedName("strHomeLineupForward")
    @Expose
    var strHomeLineupForward: String? = null
        get() = field
        set(value) {
            field = value
        }
    @SerializedName("strHomeLineupSubstitutes")
    @Expose
    var strHomeLineupSubstitutes: String? = null
        get() = field
        set(value) {
            field = value
        }
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
        get() = field
        set(value) {
            field = value
        }
    @SerializedName("strAwayLineupGoalkeeper")
    @Expose
    var strAwayLineupGoalkeeper: String? = null
        get() = field
        set(value) {
            field = value
        }
    @SerializedName("strAwayLineupDefense")
    @Expose
    var strAwayLineupDefense: String? = null
        get() = field
        set(value) {
            field = value
        }
    @SerializedName("strAwayLineupMidfield")
    @Expose
    var strAwayLineupMidfield: String? = null
        get() = field
        set(value) {
            field = value
        }
    @SerializedName("strAwayLineupForward")
    @Expose
    var strAwayLineupForward: String? = null
        get() = field
        set(value) {
            field = value
        }
    @SerializedName("strAwayLineupSubstitutes")
    @Expose
    var strAwayLineupSubstitutes: String? = null
        get() = field
        set(value) {
            field = value
        }
    @SerializedName("strAwayFormation")
    @Expose
    var strAwayFormation: String? = null
    @SerializedName("intHomeShots")
    @Expose
    var intHomeShots: String? = null
        get() = field
        set(value) {
            field = value
        }
    @SerializedName("intAwayShots")
    @Expose
    var intAwayShots: String? = null
        get() = field
        set(value) {
            field = value
        }
    @SerializedName("dateEvent")
    @Expose
    var dateEvent: String? = null
        get() = field
        set(value) {
            field = value
        }
    @SerializedName("strDate")
    @Expose
    var strDate: String? = null
        get() = field
        set(value) {
            field = value
        }
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
