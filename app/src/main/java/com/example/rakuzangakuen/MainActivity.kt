package com.example.rakuzangakuen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import com.example.rakuzangakuen.adapterPlayer.AdapterPlayer
import com.example.rakuzangakuen.model.Player
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: AdapterPlayer
    private lateinit var dataName : Array<String>
    private lateinit var dataNumber : Array<String>
    private lateinit var dataDetail : Array<String>
    private lateinit var dataImg : Array<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = AdapterPlayer(this)
        lv_rakuzan.adapter = adapter

        lv_rakuzan.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            showSelected(position)
        }

        getList()
        addList()
    }

    private fun showSelected(position: Int) {
        val intent = Intent(this@MainActivity, DetailActivity::class.java)
        intent.putExtra(DetailActivity.PLAYER, adapter.playerAdapter[position] )
        startActivity(intent)
    }

    private fun getList(){
        dataName = arrayOf(
            "Seijūrō Akashi",
            "Reo Mibuchi",
            "Kotarō Hayama",
            "Eikichi Nebuya",
            "Chihiro Mayuzumi"
        )

        dataNumber = arrayOf(
            "#4 // PG",
            "#6 // SG",
            "#7 // SF",
            "#8 // C",
            "#5 // PF"
        )

        dataDetail = arrayOf(
            "Seijūrō Akashi (赤司 征十郎 Akashi Seijūrō) was the captain of Generation of Miracles. He is the only person that the Generation of Miracles knuckles under. He is the point guard and captain of Rakuzan High and later on for Team Vorpal Swords as well.",
            "Reo Mibuchi (実渕 玲央 Mibuchi Reo) is the vice-captain and shooting guard of Rakuzan High. Because he is one of the Uncrowned Kings, he is nicknamed the Yaksha (夜叉 Yasha), referring to a kind of night spirit.",
            "Kotarō Hayama (葉山 小太郎 Hayama Kotarō) is the small forward of Rakuzan High and one of the Uncrowned Kings. His nickname is The Lightning Beast (雷獣 Raijū).",
            "Eikichi Nebuya (根武谷 永吉 Nebuya Eikichi) is the center of Rakuzan High and one of the Uncrowned Kings. He is known as the Herculean Strength (剛力 Gōriki).",
            "Chihiro Mayuzumi (黛 千尋 Mayuzumi Chihiro) was a regular member in Rakuzan High. He was a power forward and the only third year among the starting five of Rakuzan. Like Tetsuya Kuroko, he possesses the ability of Misdirection. After the Winter Cup, he retired along with the rest of the third years. His jersey number is 5."
        )

        dataImg = arrayOf(
            R.drawable.akashi,
            R.drawable.mibuchi,
            R.drawable.kotaro,
            R.drawable.eikichi,
            R.drawable.mayuzumi
        )
    }

    private fun addList(){
        for (position in dataName.indices) {
            val player = Player(
            name = dataName[position],
            number = dataNumber[position],
            detail = dataDetail[position],
            img = dataImg.get(position)
            )
            adapter.playerAdapter.add(player)
        }
    }


}