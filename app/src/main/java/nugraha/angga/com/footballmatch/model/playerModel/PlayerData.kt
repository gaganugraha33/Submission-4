package nugraha.angga.com.footballmatch.model.playerModel

import java.io.Serializable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PlayerData : Serializable {

    @SerializedName("player")
    @Expose
    var player: List<Player>? = null

    companion object {
        private const val serialVersionUID = 5181116074938885893L
    }

}
