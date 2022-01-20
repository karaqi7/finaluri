package com.example.ftest.recyclerviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ftest.R

class LewandowskiActivity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList : ArrayList<LewandowskiCars>

    lateinit var id : Array<Int>
    lateinit var imageUrl : Array<String>
    lateinit var name : Array<String>
    lateinit var price : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lewandowski)
        id = arrayOf(
            1,
            2,
            3,
            4,
            5,
            6
        )
        imageUrl = arrayOf(
            "https://autojosh.com/wp-content/uploads/2020/05/bayern-munich-robert-lewandowskis-luxury-car-collection-f12-autojosh-1.jpeg",
            "https://o.aolcdn.com/images/dims3/GLOB/crop/2560x1440+0+0/resize/800x450!/format/jpg/quality/85/https://s.yimg.com/os/creatr-uploaded-images/2019-04/20c227d0-616f-11e9-bffb-44700e338491",
            "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/2021-bentley-continental-gt-mmp-1-1595530224.jpg?crop=0.684xw:0.769xh;0.192xw,0.0841xh&resize=640:*",
            "https://autojosh.com/wp-content/uploads/2020/05/bayern-munich-robert-lewandowskis-luxury-car-collection-mercedes-autojosh.jpeg",
            "https://imgcdn.zigwheels.us/medium/gallery/exterior/24/141/maserati-granturismo-97406.jpg",
            "https://autojosh.com/wp-content/uploads/2020/05/bayern-munich-robert-lewandowskis-luxury-car-collection-audi-autojosh-1.jpg"
        )
        name = arrayOf(
            "Ferrari F12 Berlinetta",
            "Porsche 911 Speedster",
            "Bentley Continental",
            "Mercedes-AMG CL 63",
            "Maserati GranTurismo Sport",
            "Audi RS6"
        )

        price = arrayOf(
            "$325,000",
            "$275,000",
            "$202,500",
            "$154,600",
            "$325,000",
            "$109,000"
        )

        newRecyclerView = findViewById(R.id.recyclerView)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<LewandowskiCars>()
        getUserdata()


    }

    private fun getUserdata() {

        for(i in id.indices){
            val mcars = LewandowskiCars(id[i],imageUrl[i],name[i],price[i])
            newArrayList.add(mcars)

        }

        newRecyclerView.adapter = LewandowskiAdapter(newArrayList)


    }


}