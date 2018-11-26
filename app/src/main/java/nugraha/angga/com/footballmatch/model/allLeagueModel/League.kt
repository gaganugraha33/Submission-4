package nugraha.angga.com.footballmatch.model.allLeagueModel

import java.io.Serializable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class League : Serializable {

    @SerializedName("idLeague")
    @Expose
    var idLeague: String? = null
    @SerializedName("strLeague")
    @Expose
    var strLeague: String? = null
    @SerializedName("strSport")
    @Expose
    var strSport: String? = null
    @SerializedName("strLeagueAlternate")
    @Expose
    var strLeagueAlternate: String? = null

    companion object {
        private const val serialVersionUID = -298553158743008691L
    }

}
