package com.example.rakuzangakuen.adapterPlayer

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.rakuzangakuen.R
import com.example.rakuzangakuen.model.Player

class AdapterPlayer(private val context: Context) : BaseAdapter() {

    var playerAdapter : ArrayList<Player> = arrayListOf()

    class ViewHolder(itemView : View){
        val adapterName : TextView = itemView.findViewById(R.id.player_name)
        val adapterNumber : TextView = itemView.findViewById(R.id.player_number)
        val adapterImg : ImageView = itemView.findViewById(R.id.img_player)
    }

    override fun getCount(): Int {
        return playerAdapter.size
    }

    override fun getItem(position: Int): Any {
        return playerAdapter[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var itemView = convertView

        if (itemView==null){
            itemView = LayoutInflater.from(context).inflate(R.layout.player_list, parent, false)
        }

        val viewHolder = ViewHolder(itemView as View)
        val player = getItem(position) as Player
        val bind = player

        viewHolder.adapterName.text = bind.name
        viewHolder.adapterNumber.text = bind.number
        viewHolder.adapterImg.setImageResource(bind.img)

        return itemView

    }


}