package nugraha.angga.com.footballmatch.model.allLeagueModel

import java.io.Serializable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AllLeague : Serializable {

    @SerializedName("leagues")
    @Expose
    var leagues: List<League>? = null

    companion object {
        private const val serialVersionUID = -3809700119897767324L
    }

}
