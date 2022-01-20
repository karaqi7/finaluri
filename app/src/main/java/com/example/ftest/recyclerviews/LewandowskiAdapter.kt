package com.example.ftest.recyclerviews


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ftest.R

class LewandowskiAdapter(private val lewandowskiCarsList: ArrayList<LewandowskiCars>) :
    RecyclerView.Adapter<LewandowskiAdapter.LewandowskiViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LewandowskiViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate((R.layout.list_item),
            parent,false)
        return LewandowskiViewHolder(itemView)


    }

    override fun onBindViewHolder(holder: LewandowskiViewHolder, position: Int) {

        val currentItem = lewandowskiCarsList[position]
        Glide.with(holder.imageCar.context)
            .load(currentItem.imageUrl)
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(holder.imageCar)

        holder.name.text = currentItem.name
        holder.price.text = currentItem.price


    }

    override fun getItemCount(): Int {
        return lewandowskiCarsList.size
    }

    class LewandowskiViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val imageCar: ImageView = itemView.findViewById(R.id.imageCar)
        val name: TextView = itemView.findViewById(R.id.name)
        val price: TextView = itemView.findViewById(R.id.price)

    }

}