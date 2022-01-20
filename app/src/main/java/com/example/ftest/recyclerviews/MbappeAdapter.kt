package com.example.ftest.recyclerviews


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ftest.R

class MbappeAdapter(private val mbappeCarsList : ArrayList<Cars>) :
    RecyclerView.Adapter<MbappeAdapter.MbappeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MbappeViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate((R.layout.list_item),
            parent,false)
        return MbappeViewHolder(itemView)


    }

    override fun onBindViewHolder(holder: MbappeViewHolder, position: Int) {
        holder.imageCar.setClipToOutline(true)

        val currentItem = mbappeCarsList[position]
        Glide.with(holder.imageCar.context)
            .load(currentItem.imageUrl)
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(holder.imageCar)

        holder.name.text = currentItem.name
        holder.price.text = currentItem.price


    }

    override fun getItemCount(): Int {
        return mbappeCarsList.size
    }

    class MbappeViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val imageCar: ImageView = itemView.findViewById(R.id.imageCar)
        val name: TextView = itemView.findViewById(R.id.name)
        val price: TextView = itemView.findViewById(R.id.price)

    }

}