package com.example.ftest.recyclerviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ftest.R

class RonaldoActivity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList : ArrayList<RonaldoCars>

    lateinit var id : Array<Int>
    lateinit var imageUrl : Array<String>
    lateinit var name : Array<String>
    lateinit var price : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ronaldo)
        id = arrayOf(
            1,
            2,
            3,
            4,
            5,
            6,
            7,
            8,
            9,
            10
        )
        imageUrl = arrayOf(
            "https://www.financialexpress.com/wp-content/uploads/2017/05/christiano-ronaldo-car-collection-Bugatti-Veyron-768x512.jpg",
            "https://www.financialexpress.com/wp-content/uploads/2017/05/christiano-ronaldo-car-collection-lamborghini-aventador-768x512.jpg",
            "https://www.financialexpress.com/wp-content/uploads/2017/05/christiano-ronaldo-car-collection-bentley-gt-speed-768x512.jpg",
            "https://www.financialexpress.com/wp-content/uploads/2017/05/christiano-ronaldo-car-collection-aston-martin-db9-768x512.jpg",
            "https://www.financialexpress.com/wp-content/uploads/2017/05/christiano-ronaldo-car-collection-audi-r8-768x512.jpg",
            "https://www.financialexpress.com/wp-content/uploads/2017/05/christiano-ronaldo-car-collection-ferrari-599-gto-768x512.jpg",
            "https://www.financialexpress.com/wp-content/uploads/2017/05/christiano-ronaldo-car-collection-ferrari-599-gtb-fiorano-768x512.jpg",
            "https://www.financialexpress.com/wp-content/uploads/2017/05/christiano-ronaldo-car-collection-ferrari-f430-768x512.jpg",
            "https://www.financialexpress.com/wp-content/uploads/2017/05/christiano-ronaldo-car-collection-rolls-royce-phantom-768x512.jpg",
            "https://www.financialexpress.com/wp-content/uploads/2017/05/christiano-ronaldo-car-collection-maserati-grancabrio-768x512.jpg"

        )
        name = arrayOf(
            "Bugatti Veyron",
            "Lamborghini Aventador LP 700-4",
            "Bentley GT Speed",
            "Aston Martin DB9",
            "Audi R8",
            "Ferrari 599 GTO",
            "Ferrari 599 GTB Fiorano",
            "Ferrari F430",
            "Rolls Royce Phantom",
            "Maserati GranCabrio"
        )

        price = arrayOf(
            "$1.7 million",
            "$3,18,000",
            "$220,000",
            "$200,000",
            "$150,000",
            "$3,85,000",
            "$310,000",
            "$300,000",
            "$400,000",
            "$140,000"

        )

        newRecyclerView = findViewById(R.id.recyclerView)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<RonaldoCars>()
        getUserdata()


    }

    private fun getUserdata() {

        for(i in id.indices){
            val mcars = RonaldoCars(id[i],imageUrl[i],name[i],price[i])
            newArrayList.add(mcars)

        }

        newRecyclerView.adapter = RonaldoAdapter(newArrayList)


    }


}