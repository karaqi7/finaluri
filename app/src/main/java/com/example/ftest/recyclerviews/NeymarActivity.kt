package com.example.ftest.recyclerviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ftest.R

class NeymarActivity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList : ArrayList<NeymarCars>

    lateinit var id : Array<Int>
    lateinit var imageUrl : Array<String>
    lateinit var name : Array<String>
    lateinit var price : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_neymar)
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

        newArrayList = arrayListOf<NeymarCars>()
        getUserdata()


    }

    private fun getUserdata() {

        for(i in id.indices){
            val mcars = NeymarCars(id[i],imageUrl[i],name[i],price[i])
            newArrayList.add(mcars)

        }

        newRecyclerView.adapter = NeymarAdapter(newArrayList)


    }


}