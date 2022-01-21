package com.example.ftest.fragments.easteregg




import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ftest.R

class WaifuActivity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList : ArrayList<Waifus>

    lateinit var id : Array<Int>
    lateinit var imageUrl : Array<String>
    lateinit var name : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_waifu)
        id = arrayOf(
            1,
            2,
            3,
            4
        )
        imageUrl = arrayOf(
            "https://static.wikia.nocookie.net/b4d30607-fff1-474a-b834-b85eacb2faf4",
            "https://static.wikia.nocookie.net/nisekoi/images/c/c6/Chitoge-nisekoi.png/revision/latest?cb=20150603043239",
            "https://cdn1.dotesports.com/wp-content/uploads/2021/09/14162137/Akali_9.jpg",
            "https://ddragon.leagueoflegends.com/cdn/img/champion/splash/Ahri_0.jpg"
        )
        name = arrayOf(
            "Tohsaka Rin[Sauce 271007]",
            "Chitoge Kirisaki",
            "Akali",
            "Ahri"
        )


        newRecyclerView = findViewById(R.id.recyclerView)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<Waifus>()
        getUserdata()


    }

    private fun getUserdata() {

        for(i in id.indices){
            val mwaifus = Waifus(id[i],imageUrl[i],name[i])
            newArrayList.add(mwaifus)

        }

        newRecyclerView.adapter = WaifuAdapter(newArrayList)


    }


}