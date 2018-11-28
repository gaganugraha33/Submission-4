package nugraha.angga.com.footballmatch.model.playerModel

import java.io.Serializable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Player : Serializable {

    @SerializedName("idPlayer")
    @Expose
    var idPlayer: String? = null
    @SerializedName("idTeam")
    @Expose
    var idTeam: String? = null
    @SerializedName("idSoccerXML")
    @Expose
    var idSoccerXML: String? = null
    @SerializedName("idPlayerManager")
    @Expose
    var idPlayerManager: Any? = null
    @SerializedName("strNationality")
    @Expose
    var strNationality: String? = null
    @SerializedName("strPlayer")
    @Expose
    var strPlayer: String? = null
    @SerializedName("strTeam")
    @Expose
    var strTeam: String? = null
    @SerializedName("strSport")
    @Expose
    var strSport: String? = null
    @SerializedName("intSoccerXMLTeamID")
    @Expose
    var intSoccerXMLTeamID: String? = null
    @SerializedName("dateBorn")
    @Expose
    var dateBorn: String? = null
    @SerializedName("dateSigned")
    @Expose
    var dateSigned: String? = null
    @SerializedName("strSigning")
    @Expose
    var strSigning: String? = null
    @SerializedName("strWage")
    @Expose
    var strWage: String? = null
    @SerializedName("strBirthLocation")
    @Expose
    var strBirthLocation: String? = null
    @SerializedName("strDescriptionEN")
    @Expose
    var strDescriptionEN: String? = null
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
    @SerializedName("strPosition")
    @Expose
    var strPosition: String? = null
    @SerializedName("strCollege")
    @Expose
    var strCollege: Any? = null
    @SerializedName("strFacebook")
    @Expose
    var strFacebook: String? = null
    @SerializedName("strWebsite")
    @Expose
    var strWebsite: String? = null
    @SerializedName("strTwitter")
    @Expose
    var strTwitter: String? = null
    @SerializedName("strInstagram")
    @Expose
    var strInstagram: String? = null
    @SerializedName("strYoutube")
    @Expose
    var strYoutube: String? = null
    @SerializedName("strHeight")
    @Expose
    var strHeight: String? = null
    @SerializedName("strWeight")
    @Expose
    var strWeight: String? = null
    @SerializedName("intLoved")
    @Expose
    var intLoved: String? = null
    @SerializedName("strThumb")
    @Expose
    var strThumb: String? = null
    @SerializedName("strCutout")
    @Expose
    var strCutout: String? = null
    @SerializedName("strBanner")
    @Expose
    var strBanner: Any? = null
    @SerializedName("strFanart1")
    @Expose
    var strFanart1: String? = null
    @SerializedName("strFanart2")
    @Expose
    var strFanart2: String? = null
    @SerializedName("strFanart3")
    @Expose
    var strFanart3: String? = null
    @SerializedName("strFanart4")
    @Expose
    var strFanart4: String? = null
    @SerializedName("strLocked")
    @Expose
    var strLocked: String? = null

    companion object {
        private const val serialVersionUID = -6637328516015913998L
    }

}
