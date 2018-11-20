package nugraha.angga.com.footballmatch.adapter

import android.graphics.Typeface
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import nugraha.angga.com.footballmatch.R
import nugraha.angga.com.footballmatch.model.EventMatchModel.EventMatch
import org.jetbrains.anko.*
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class MatchAdapter(private val lastMatch: List<EventMatch>, private val listener:(EventMatch) -> Unit): RecyclerView.Adapter<MatchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
       return MatchViewHolder(MatchUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun getItemCount(): Int  = lastMatch.size

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        holder.bindItem(lastMatch[position], listener)
    }

}

fun getDateWithServerTimeStamp(date:String): String {
    var spf = SimpleDateFormat("yyyy-MM-dd")
    val newDate = spf.parse(date)
    spf = SimpleDateFormat("EEE, d MMM yyyy")
    val dateNewFormat = spf.format(newDate)

    return dateNewFormat.toString()

}

class MatchViewHolder(view: View):RecyclerView.ViewHolder(view){
    private var dateMatchText:TextView = view.find(R.id.date_match)
    private var homeTeamText:TextView = view.find(R.id.home_team)
    private var homeScoreText:TextView = view.find(R.id.home_score)
    private var vsText:TextView = view.find(R.id.vs)
    private var awayScoreText:TextView = view.find(R.id.away_score)
    private var awayTeamText:TextView = view.find(R.id.away_team)

    fun bindItem(lastMatch: EventMatch, listener: (EventMatch) -> Unit){
        println("cek isi tanggal ${lastMatch.strDate}")
        dateMatchText!!.text = getDateWithServerTimeStamp(lastMatch.dateEvent.toString())
        homeTeamText!!.text = lastMatch.strHomeTeam
        homeScoreText!!.text = lastMatch.intHomeScore
        vsText!!.text = "vs"
        awayScoreText!!.text = lastMatch.intAwayScore
        awayTeamText!!.text = lastMatch.strAwayTeam

        itemView.setOnClickListener {
            listener(lastMatch)
        }
    }
}



class MatchUI:AnkoComponent<ViewGroup>{

    override fun createView(ui: AnkoContext<ViewGroup>): View {
        return with(ui){
            linearLayout{
                lparams(width = matchParent, height = wrapContent)
                padding = dip(10)
                orientation = LinearLayout.VERTICAL
                gravity = Gravity.CENTER

                textView{
                    padding = dip(16)
                    id = R.id.date_match
                    textSize = 16f
                    gravity = Gravity.CENTER
                    textColor = ContextCompat.getColor(ctx, R.color.colorPrimary)
                }.lparams(width = matchParent)

                linearLayout {
                    lparams(width = matchParent, height = wrapContent)
                    orientation = LinearLayout.HORIZONTAL
                    gravity = Gravity.CENTER

                    textView{
                        id = R.id.home_team
                        gravity = Gravity.CENTER
                        textSize = 16f
                        textColor = ContextCompat.getColor(ctx, R.color.black)
                    }.lparams(width = matchParent){
                        weight = 1.0F
//                        leftMargin = dip(10)
                    }

                    linearLayout {
                        lparams(width = matchParent){
                            weight = 1.0F
                        }
                        orientation = LinearLayout.HORIZONTAL
                        gravity = Gravity.CENTER
                        textView{
                            id = R.id.home_score
                            textSize = 18f
                            textColor = ContextCompat.getColor(ctx, R.color.black)
                            typeface = Typeface.createFromAsset(context.assets, "fonts/Roboto-Bold.ttf")
//                        typeface = Typeface.createFromAsset(context.assets, "fonts/Roboto-Medium.ttf")
                        }.lparams(){
                            leftMargin = dip(5)
                        }


                        textView{
                            id = R.id.vs
                            textSize = 15f
                            textColor = ContextCompat.getColor(ctx, R.color.black)
                        }.lparams(){
                            leftMargin = dip(10)
                        }


                        textView{
                            id = R.id.away_score
                            textSize = 18f
                            textColor = ContextCompat.getColor(ctx, R.color.black)
                            typeface = Typeface.createFromAsset(context.assets, "fonts/Roboto-Bold.ttf")
                        }.lparams(){
                            leftMargin = dip(10)
                        }
                    }

                    textView{
                        id = R.id.away_team
                        textSize = 16f
                        gravity = Gravity.CENTER
                        textColor = ContextCompat.getColor(ctx, R.color.black)
                    }.lparams(width = matchParent){
//                        rightMargin = dip(10)
                        weight = 1.0F
                    }
                }
            }
        }
    }

}

