package com.example.ftest.recyclerviews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ftest.R

class RecyclerViewCarsAdapter(private val list: List<Cars>):
        RecyclerView.Adapter<RecyclerViewCarsAdapter.CarsViewHolder>() {

            class CarsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

                var imageCar : ImageView
                var carName : TextView
                var carPrice : TextView

                init {
                    imageCar = itemView.findViewById(R.id.imageCar)
                    carName = itemView.findViewById(R.id.carName)
                    carPrice = itemView.findViewById(R.id.carPrice)
                }
                fun setData(cars: Cars) {
                    Glide.with(imageCar).load(cars.imageUrl).into(imageCar) // ეს კიდევ გადასახედია, შეიძლება პირველი imageCar-ის ნაცვლად უნდა itemView
                    carName.text = cars.name
                    carPrice.text = cars.price
                }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarsViewHolder {
        val carsView = LayoutInflater.from(parent.context).inflate(R.layout.cars_adapter, parent, false)
        return CarsViewHolder(carsView)
    }

    override fun onBindViewHolder(holder: CarsViewHolder, position: Int) {
        val p = list[position]
        holder.setData(p)
    }

    override fun getItemCount() = list.size

}

