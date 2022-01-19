package com.example.ftest.recyclerviews

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ftest.R

class MessiFragment : Fragment(R.layout.recycler_messi) {
    private lateinit var recyclerView : RecyclerView
    private lateinit var recyclerViewCarsAdapter: RecyclerViewCarsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerViewCarsAdapter = RecyclerViewCarsAdapter(getData())
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = recyclerViewCarsAdapter
    }

    private fun getData(): List<Cars> {
        val carsList = ArrayList<Cars>()

        carsList.add(Cars(
            1,
            "https://www.carpixx.ch/wp-content/uploads/2021/09/1957_Ferrari_335_Sport_Scaglietti.jpg",
            "Ferrari 335 S Spider Scaglietti",
            "$37 million"
        ))
        carsList.add(Cars(
            2,
            "https://img.mensxp.com/media/content/2019/Sep/a-sneak-peek-at-messi-rsquo-s-garage4-1569328734.jpg",
            "Pagani Zonda Tricolore",
            "$2 million"
        ))
        carsList.add(Cars(
            3,
            "https://i0.wp.com/21motoring.com/wp-content/uploads/2021/06/WhatsApp-Image-2021-06-08-at-4.17.55-PM.jpeg?resize=448%2C252&ssl=1",
            "Mercedes SLS AMG",
            "$642,000"
        ))
        carsList.add(Cars(
            4,
            "https://s1.cdn.autoevolution.com/images/news/lionel-messis-maserati-granturismo-mc-stradale-offered-for-sale-looks-gaudy-114339_1.jpg",
            "Maserati Gran Turismo MC Stradale",
            "$242,000"
        ))
        carsList.add(Cars(
            5,
            "https://i.pinimg.com/originals/bb/35/6e/bb356e54dd5e26306ae6edad84267b31.jpg",
            "Ferrari F430 Spyder",
            "$164,000"
        ))
        carsList.add(Cars(
            6,
            "https://gomechanic.in/blog/wp-content/uploads/2020/08/Lionel-Messi-Cars.jpg",
            "Audi RS6",
            "$108,000"
        ))
        carsList.add(Cars(
            7,
            "https://www.cartoq.com/wp-content/uploads/2018/06/Audi-A7-Messi_1.jpg",
            "Audi A7",
            "$70,000"
        ))
        carsList.add(Cars(
            8,
            "https://pbs.twimg.com/media/Cv0k7-HVYAARduJ.jpg",
            "Audi Q7",
            "$54,500"
        ))
        carsList.add(Cars(
            9,
            "https://www.hellomonaco.com/wordpress/wp-content/uploads/2017/06/Audi-R8-V10.jpeg",
            "Audi R7 Spyder",
            "$190,000"
        ))
        carsList.add(Cars(
            10,
            "https://f7432d8eadcf865aa9d9-9c672a3a4ecaaacdf2fee3b3e6fd2716.ssl.cf3.rackcdn.com/C2299/U8092/IMG_30015-large.jpg",
            "Range Rover Vogue",
            "$200,000"
        ))
        carsList.add(Cars(
            11,
            "https://gomechanic.in/blog/wp-content/uploads/2020/08/Land-Rover-Range-Rover-Sport.jpg",
            "Range Rover Sport",
            "$85,000"
        ))
        carsList.add(Cars(
            12,
            "https://i0.wp.com/tn.com.ar/resizer/VIFNkof99x0vduKA_Ufq2mg6Oak=/767x0/smart/filters:quality(60)/cloudfront-us-east-1.images.arcpublishing.com/artear/XILX3CAUGZCDHPJM7EILQQJI2M.jpg?w=800&ssl=1",
            "Cadillac Escalade",
            "$75,000"
        ))
        carsList.add(Cars(
            13,
            "https://www.priorityauto.com/inventoryphotos/2493/2t2hgmda4nc078864/ip/1.jpg?height=400",
            "Lexus RX 450h",
            "$46,000"
        ))

        return carsList
    }
}