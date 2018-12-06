package nugraha.angga.com.footballmatch.menumatches.adapter

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import nugraha.angga.com.footballmatch.R
import nugraha.angga.com.footballmatch.model.eventMatchModel.EventMatch
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

class MatchAdapter(private val lastMatch: List<EventMatch>,private val type:String, private val context: Context,private val listener:(EventMatch) -> Unit): RecyclerView.Adapter<MatchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
       return MatchViewHolder(MatchUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun getItemCount(): Int  = lastMatch.size

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        holder.bindItem(lastMatch[position], type,context, listener)
    }

}

fun getDateWithServerTimeStamp(date:String): String {
    var spf = SimpleDateFormat("yyyy-MM-dd")
    val newDate = spf.parse(date)
    spf = SimpleDateFormat("EEE, d MMM yyyy")
    val dateNewFormat = spf.format(newDate)

    return dateNewFormat.toString()

}

fun formatGMTMatch(dateMatch: String?, timeMatch: String?): Date? {
   try {
       val formatClock = "yyyy-MM-dd HH:mm:ss"
       val formatterMatch = SimpleDateFormat(formatClock)
       formatterMatch.timeZone = TimeZone.getTimeZone("UTC")
       val dateTimeMatch = "$dateMatch $timeMatch"
       return formatterMatch.parse(dateTimeMatch)
   }catch (exception:Exception){
       return null
   }
}

class MatchViewHolder(view: View):RecyclerView.ViewHolder(view){
    private var dateMatchText:TextView = view.find(R.id.date_match)
    private var clockText:TextView = view.find(R.id.date_clock)
    private var homeTeamText:TextView = view.find(R.id.home_team)
    private var homeScoreText:TextView = view.find(R.id.home_score)
    private var vsText:TextView = view.find(R.id.vs)
    private var awayScoreText:TextView = view.find(R.id.away_score)
    private var awayTeamText:TextView = view.find(R.id.away_team)
    private val bellImage: ImageView = view.find(R.id.bell)

    fun bindItem(lastMatch: EventMatch, type:String, context: Context ,listener: (EventMatch) -> Unit){

        bellImage.visibility = View.GONE

        val dateTimeMatch = formatGMTMatch(lastMatch.dateEvent, lastMatch.strTime)
        try {
            val clockMatch = SimpleDateFormat("HH:mm", Locale.getDefault()).format(dateTimeMatch)
            clockText.text = clockMatch
        }catch (exception:Exception){
            clockText.text = ""
        }


        dateMatchText.text = getDateWithServerTimeStamp(lastMatch.dateEvent.toString())

        homeTeamText.text = lastMatch.strHomeTeam
        if(lastMatch.intHomeScore != null){
            homeScoreText.text = lastMatch.intHomeScore.toString()
        }else{
            homeScoreText.text = ""
        }

        if(lastMatch.intAwayScore != null){
            awayScoreText.text = lastMatch.intAwayScore.toString()
        }else{
            awayScoreText.text = ""
        }

        vsText.text = "vs"

        awayTeamText.text = lastMatch.strAwayTeam

        itemView.setOnClickListener {
            listener(lastMatch)
        }
    }
}



class MatchUI:AnkoComponent<ViewGroup>{

    override fun createView(ui: AnkoContext<ViewGroup>): View {
        return with(ui){

            frameLayout {
                lparams(width = matchParent, height = wrapContent)
                cardView {
                    id = R.id.cardMatch
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
                        orientation = LinearLayout.VERTICAL
                        gravity = Gravity.CENTER

                       linearLayout {
                           lparams(width = matchParent, height = wrapContent)
                           padding = dip(2)
                           orientation = LinearLayout.VERTICAL
                           gravity = Gravity.RIGHT

                           imageView {
                               id = R.id.bell
                           }.lparams{
                               height = dip(20)
                               width = dip(20)
                           }

                       }

                        textView{
                            padding = dip(6)
                            id = R.id.date_match
                            textSize = 16f
                            gravity = Gravity.CENTER
                            textColor = ContextCompat.getColor(ctx, R.color.colorPrimary)
                        }.lparams(width = matchParent)

                        textView{
                            padding = dip(6)
                            id = R.id.date_clock
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
    }

}

