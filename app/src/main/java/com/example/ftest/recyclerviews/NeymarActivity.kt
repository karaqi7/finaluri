package com.example.ftest.recyclerviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ftest.R

class NeymarActivity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList : ArrayList<Cars>

    lateinit var id : Array<Int>
    lateinit var imageUrl : Array<String>
    lateinit var name : Array<String>
    lateinit var price : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_neymar)
        id = arrayOf(
            1,
            2,
            3,
            4,
            5,
            6,
            7,
            8
        )
        imageUrl = arrayOf(
            "https://cdn.kickoff.com/cms2/image_manager/uploads/News/707195/7/Koenigsegg-Trevita-V1-1440.jpg",
            "https://www.topcarrating.com/lamborghini/2013-lamborghini-veneno-11.jpg",
            "https://upload.wikimedia.org/wikipedia/commons/e/e6/Lykan_HyperSport.jpg",
            "https://hips.hearstapps.com/roa.h-cdn.co/assets/16/46/1479135693-screen-shot-2016-11-14-at-95609-am.png",
            "https://cdn.carbuzz.com/gallery-images/840x560/813000/400/813452.jpg",
            "https://media.daimler.com/marsMediaSite/scr/1634890153000/46940071v7tv3/D600009-Mercedes-AMG-GT-now-available-to-order-as-Coup-and-Roadster-Sales-start-for-the-new-Performance-models.jpg",
            "https://autotras.com/images/89/ferrari-458-italia-prices.jpg",
            "https://www.topcarrating.com/aston-martin/2016-aston-martin-vulcan-8.jpg"

        )
        name = arrayOf(
            "Koenigsegg CCXR Trevita",
            "Lamborghini Veneno",
            "Lykan Hypersport",
            "Maserati Mc12",
            "Audi R8 Spyder",
            "Mercedes AMG GT",
            "Ferrari 458 Italia",
            "Aston Martin Vulcan"
        )

        price = arrayOf(
            "$4.2 million",
            "$4,500,000",
            "$3.4 million",
            "$2.4 million",
            "$170,000",
            "$153,500",
            "$239,340",
            "$2.3 million"
        )

        newRecyclerView = findViewById(R.id.recyclerView)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<Cars>()
        getUserdata()


    }

    private fun getUserdata() {

        for(i in id.indices){
            val mcars = Cars(id[i],imageUrl[i],name[i],price[i])
            newArrayList.add(mcars)

        }

        newRecyclerView.adapter = NeymarAdapter(newArrayList)


    }


}