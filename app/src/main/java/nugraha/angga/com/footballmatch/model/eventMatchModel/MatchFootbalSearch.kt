package nugraha.angga.com.footballmatch.model.eventMatchModel

import java.io.Serializable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MatchFootbalSearch : Serializable {

    @SerializedName("event")
    @Expose
    var event: List<EventMatch>? = null

    companion object {
        private const val serialVersionUID = -3030833050572786752L
    }

}
