package nugraha.angga.com.footballmatch.menuteam.adapter

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
import nugraha.angga.com.footballmatch.model.allTeamLeagueModel.Team
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

class AllTeamAdapter(private val allTeamLIst: List<Team>, private val listener:(Team) -> Unit): RecyclerView.Adapter<AllTeamViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllTeamViewHolder {
       return AllTeamViewHolder(AllTeamUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun getItemCount(): Int  = allTeamLIst.size

    override fun onBindViewHolder(holder: AllTeamViewHolder, position: Int) {
        holder.bindItem(allTeamLIst[position], listener)
    }

}


class AllTeamViewHolder(view: View):RecyclerView.ViewHolder(view){
    private val allTeamText:TextView = view.find(R.id.all_team)
    private val teamBadge: ImageView = view.find(R.id.team_badge)

    fun bindItem(allTeamLIst: Team, listener: (Team) -> Unit){
        allTeamText.text = allTeamLIst.strTeam
        Glide.with(teamBadge).load(allTeamLIst.strTeamBadge).into(teamBadge)

        itemView.setOnClickListener {
            listener(allTeamLIst)
        }
    }
}


class AllTeamUI:AnkoComponent<ViewGroup>{

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
                        padding = dip(10)
                        orientation = LinearLayout.HORIZONTAL
                        gravity = Gravity.CENTER


                        imageView {
                            id = R.id.team_badge
                        }.lparams{
                            height = dip(50)
                            width = dip(50)
                        }

                        textView{
                            padding = dip(16)
                            id = R.id.all_team
                            textSize = 16f
                            textColor = ContextCompat.getColor(ctx, R.color.colorPrimary)
                        }.lparams(width = matchParent)

                    }

                }
            }

        }
    }

}

