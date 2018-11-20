package nugraha.angga.com.footballmatch.model.AllTeamLeagueModel

import java.io.Serializable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AllTeamLeague : Serializable {

    @SerializedName("teams")
    @Expose
    var teams: List<Team>? = null

    companion object {
        private const val serialVersionUID = 6350574509007124590L
    }

}
