package nugraha.angga.com.footballmatch.model.AllTeamLeagueModel

import java.io.Serializable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Team : Serializable {

    @SerializedName("idTeam")
    @Expose
    var idTeam: String? = null
    @SerializedName("idSoccerXML")
    @Expose
    var idSoccerXML: String? = null
    @SerializedName("intLoved")
    @Expose
    var intLoved: String? = null
    @SerializedName("strTeam")
    @Expose
    var strTeam: String? = null
    @SerializedName("strTeamShort")
    @Expose
    var strTeamShort: Any? = null
    @SerializedName("strAlternate")
    @Expose
    var strAlternate: String? = null
    @SerializedName("intFormedYear")
    @Expose
    var intFormedYear: String? = null
    @SerializedName("strSport")
    @Expose
    var strSport: String? = null
    @SerializedName("strLeague")
    @Expose
    var strLeague: String? = null
    @SerializedName("idLeague")
    @Expose
    var idLeague: String? = null
    @SerializedName("strDivision")
    @Expose
    var strDivision: Any? = null
    @SerializedName("strManager")
    @Expose
    var strManager: String? = null
    @SerializedName("strStadium")
    @Expose
    var strStadium: String? = null
    @SerializedName("strKeywords")
    @Expose
    var strKeywords: String? = null
    @SerializedName("strRSS")
    @Expose
    var strRSS: String? = null
    @SerializedName("strStadiumThumb")
    @Expose
    var strStadiumThumb: String? = null
    @SerializedName("strStadiumDescription")
    @Expose
    var strStadiumDescription: Any? = null
    @SerializedName("strStadiumLocation")
    @Expose
    var strStadiumLocation: String? = null
    @SerializedName("intStadiumCapacity")
    @Expose
    var intStadiumCapacity: String? = null
    @SerializedName("strWebsite")
    @Expose
    var strWebsite: String? = null
    @SerializedName("strFacebook")
    @Expose
    var strFacebook: String? = null
    @SerializedName("strTwitter")
    @Expose
    var strTwitter: String? = null
    @SerializedName("strInstagram")
    @Expose
    var strInstagram: String? = null
    @SerializedName("strDescriptionEN")
    @Expose
    var strDescriptionEN: Any? = null
    @SerializedName("strDescriptionDE")
    @Expose
    var strDescriptionDE: Any? = null
    @SerializedName("strDescriptionFR")
    @Expose
    var strDescriptionFR: Any? = null
    @SerializedName("strDescriptionCN")
    @Expose
    var strDescriptionCN: Any? = null
    @SerializedName("strDescriptionIT")
    @Expose
    var strDescriptionIT: Any? = null
    @SerializedName("strDescriptionJP")
    @Expose
    var strDescriptionJP: Any? = null
    @SerializedName("strDescriptionRU")
    @Expose
    var strDescriptionRU: Any? = null
    @SerializedName("strDescriptionES")
    @Expose
    var strDescriptionES: Any? = null
    @SerializedName("strDescriptionPT")
    @Expose
    var strDescriptionPT: Any? = null
    @SerializedName("strDescriptionSE")
    @Expose
    var strDescriptionSE: Any? = null
    @SerializedName("strDescriptionNL")
    @Expose
    var strDescriptionNL: Any? = null
    @SerializedName("strDescriptionHU")
    @Expose
    var strDescriptionHU: Any? = null
    @SerializedName("strDescriptionNO")
    @Expose
    var strDescriptionNO: Any? = null
    @SerializedName("strDescriptionIL")
    @Expose
    var strDescriptionIL: Any? = null
    @SerializedName("strDescriptionPL")
    @Expose
    var strDescriptionPL: Any? = null
    @SerializedName("strGender")
    @Expose
    var strGender: String? = null
    @SerializedName("strCountry")
    @Expose
    var strCountry: String? = null
    @SerializedName("strTeamBadge")
    @Expose
    var strTeamBadge: String? = null
    @SerializedName("strTeamJersey")
    @Expose
    var strTeamJersey: String? = null
    @SerializedName("strTeamLogo")
    @Expose
    var strTeamLogo: String? = null
    @SerializedName("strTeamFanart1")
    @Expose
    var strTeamFanart1: String? = null
    @SerializedName("strTeamFanart2")
    @Expose
    var strTeamFanart2: String? = null
    @SerializedName("strTeamFanart3")
    @Expose
    var strTeamFanart3: String? = null
    @SerializedName("strTeamFanart4")
    @Expose
    var strTeamFanart4: String? = null
    @SerializedName("strTeamBanner")
    @Expose
    var strTeamBanner: String? = null
    @SerializedName("strYoutube")
    @Expose
    var strYoutube: String? = null
    @SerializedName("strLocked")
    @Expose
    var strLocked: String? = null

    companion object {
        private const val serialVersionUID = -8970788252154483847L
    }

}
