package nugraha.angga.com.footballmatch.model.eventMatchModel

import java.io.Serializable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MatchFootbal : Serializable {

    @SerializedName("events")
    @Expose
    var events: List<EventMatch>? = null

    companion object {
        private const val serialVersionUID = -6782917911469163266L
    }

}
