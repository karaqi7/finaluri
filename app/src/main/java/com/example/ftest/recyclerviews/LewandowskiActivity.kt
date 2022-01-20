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
            //example shown in MessiActivity

        )
        imageUrl = arrayOf(
            //example shown in MessiActivity


        )
        name = arrayOf(
            //example shown in MessiActivity


        )

        price = arrayOf(
            //example shown in MessiActivity


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