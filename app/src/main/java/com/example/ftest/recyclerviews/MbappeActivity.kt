package com.example.ftest.recyclerviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ftest.R

class MbappeActivity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList : ArrayList<Cars>

    lateinit var id : Array<Int>
    lateinit var imageUrl : Array<String>
    lateinit var name : Array<String>
    lateinit var price : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mbappe)
        id = arrayOf(
            1,
            2,
            3,
            4,
            5,
            6
        )
        imageUrl = arrayOf(
            "https://ag-spots-2021.o.auroraobjects.eu/2021/05/28/ferrari-488-pista-c384128052021185912_2.jpg",
            "https://www.autocar.co.uk/sites/autocar.co.uk/files/styles/gallery_slide/public/images/car-reviews/first-drives/legacy/ferrari_sf90_stradale_2.jpg?itok=LH05LCpz",
            "https://i0.wp.com/thesportslite.com/wp-content/uploads/2021/11/image-20210630012313-1.jpeg?resize=300%2C245&ssl=1",
            "https://i0.wp.com/thesportslite.com/wp-content/uploads/2021/11/multivan.jpeg?resize=225%2C300&ssl=1",
            "https://i0.wp.com/thesportslite.com/wp-content/uploads/2021/11/tiguan.jpg?resize=300%2C170&ssl=1",
            "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/2022-volkswagen-tiguan-us-spec-101-1620753302.jpg?crop=0.694xw:0.522xh;0.152xw,0.337xh&resize=1200:*"

        )
        name = arrayOf(
            "Ferrari 488 Pista",
            "Ferrari Hybrid SF90 Stradale",
            "Mercedes-Benz V Class",
            "Volkswagen Multi Van",
            "Volkswagen Touareg",
            "Volkswagen Tiguan"
        )

        price = arrayOf(
            "€527,350",
            "€430,000",
            "€134,552",
            "€80,000",
            "€120,000",
            "€57,000"
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

        newRecyclerView.adapter = MbappeAdapter(newArrayList)


    }


}