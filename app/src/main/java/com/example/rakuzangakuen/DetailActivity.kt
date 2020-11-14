package com.example.rakuzangakuen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rakuzangakuen.model.Player
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object{
        const val PLAYER = "player"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val player = intent.getParcelableExtra<Player>(PLAYER) as Player

        detail_name.text = player.name
        detail_number.text = player.number
        detail_detail.text = player.detail
        img_detail.setImageResource(player.img)
    }
}