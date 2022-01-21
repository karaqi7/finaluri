package com.example.ftest.fragments.easteregg


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ftest.R
import com.example.ftest.fragments.easteregg.Waifus

class WaifuAdapter(private val waifusList: ArrayList<Waifus>) :
    RecyclerView.Adapter<WaifuAdapter.WaifuViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WaifuViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate((R.layout.waifus),
            parent,false)
        return WaifuViewHolder(itemView)


    }

    override fun onBindViewHolder(holder: WaifuViewHolder, position: Int) {
        holder.imageWaifu.setClipToOutline(true)
        val currentItem = waifusList[position]
        Glide.with(holder.imageWaifu.context)
            .load(currentItem.imageUrl)
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(holder.imageWaifu)

        holder.name.text = currentItem.name


    }

    override fun getItemCount(): Int {
        return waifusList.size
    }

    class WaifuViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val imageWaifu: ImageView = itemView.findViewById(R.id.imageWaifu)
        val name: TextView = itemView.findViewById(R.id.name)

    }

}