package nugraha.angga.com.footballmatch.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.player_detail_activity_layout.*
import nugraha.angga.com.footballmatch.R
import nugraha.angga.com.footballmatch.model.playerModel.Player

class PlayerDetailActivity:AppCompatActivity() {
    private var player:Player? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.player_detail_activity_layout)
        val actionBar = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)

        player = intent.getSerializableExtra("data") as Player
        Glide.with(img_player).load(player?.strFanart1.toString()).into(img_player)
        tvWeight.text = player?.strWeight.toString()
        tvHeight.text = player?.strHeight.toString()
        tvDescPlayer.text = player?.strDescriptionEN.toString()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}