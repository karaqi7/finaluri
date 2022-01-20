package com.example.ftest.recyclerviews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ftest.R

class MessiAdapter(private val messiCarsList : ArrayList<MessiCars>) :
    RecyclerView.Adapter<MessiAdapter.MessiViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessiViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate((R.layout.list_item),
            parent,false)
        return MessiViewHolder(itemView)


    }

    override fun onBindViewHolder(holder: MessiViewHolder, position: Int) {

        val currentItem = messiCarsList[position]
        Glide.with(holder.imageCar.context)
            .load(currentItem.imageUrl)
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(holder.imageCar)

        holder.name.text = currentItem.name
        holder.price.text = currentItem.price


    }

    override fun getItemCount(): Int {
        return messiCarsList.size
    }

    class MessiViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val imageCar: ImageView = itemView.findViewById(R.id.imageCar)
        val name: TextView = itemView.findViewById(R.id.name)
        val price: TextView = itemView.findViewById(R.id.price)

    }

}