package nugraha.angga.com.footballmatch.menuplayer.adapter

import android.graphics.Color
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import nugraha.angga.com.footballmatch.R
import nugraha.angga.com.footballmatch.model.playerModel.Player
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

class PlayerAdapter(private val listPlayerData: List<Player>, private val listener:(Player) -> Unit): RecyclerView.Adapter<PlayerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
       return PlayerViewHolder(PlayerUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun getItemCount(): Int  = listPlayerData.size

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        holder.bindItem(listPlayerData[position], listener)
    }

}

class PlayerViewHolder(view: View):RecyclerView.ViewHolder(view){
    private val namePlayerText:TextView = view.find(R.id.name_player)
    private val positionPlaerText:TextView = view.find(R.id.position_player)
    private val playerImage: ImageView = view.find(R.id.player_image)

    fun bindItem(player: Player, listener: (Player) -> Unit){
        namePlayerText.text = player.strPlayer
        positionPlaerText.text = player.strPosition
        Glide.with(playerImage).load(player.strCutout).into(playerImage)

        itemView.setOnClickListener {
            listener(player)
        }
    }
}

class PlayerUI:AnkoComponent<ViewGroup>{

    override fun createView(ui: AnkoContext<ViewGroup>): View {
        return with(ui){
            frameLayout {
                lparams(width = matchParent, height = wrapContent)
                cardView {
                    lparams(width = matchParent, height = wrapContent)
                    layoutParams = FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT).apply {
                        leftMargin = dip(5)
                        rightMargin = dip(5)
                        topMargin = dip(3)
                        bottomMargin = dip(3)

                    }
                    backgroundColor = Color.WHITE
                    radius = dip(8).toFloat()


                    linearLayout{
                        lparams(width = matchParent, height = wrapContent)
                        padding = dip(1)
                        orientation = LinearLayout.HORIZONTAL
                        gravity = Gravity.CENTER


                        imageView {
                            id = R.id.player_image
                        }.lparams{
                            height = wrapContent
                            width = dip(50)
                        }

                        textView{
                            padding = dip(16)
                            id = R.id.name_player
                            textSize = 16f
                            textColor = ContextCompat.getColor(ctx, R.color.colorPrimary)
                        }.lparams(width = matchParent, height = wrapContent, weight = 1F)

                        textView{
                            padding = dip(16)
                            id = R.id.position_player
                            textSize = 16f
                            gravity = Gravity.RIGHT
                            textColor = ContextCompat.getColor(ctx, R.color.colorPrimary)
                        }.lparams(width = matchParent, height = wrapContent, weight = 1F)

                    }

                }
            }
        }
    }

}

