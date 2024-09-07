package com.example.recycleviewassignment

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList: ArrayList<DataClass>
    private lateinit var imageList: Array<Int>
     private lateinit var titleList:Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        imageList = arrayOf(
            R.drawable.banana,
            R.drawable.mango,
            R.drawable.tangerine,
            R.drawable.orange,
            R.drawable.strawberries,
            R.drawable.berries,
            R.drawable.apple,
            R.drawable.plums,
            R.drawable.avocados,
            R.drawable.watermelon
        )  // <- Closing parenthesis added here

        titleList = arrayOf(
            "Banana",
            "Mango",
            "Tangerine",
            "Orange",
            "Strawberries",
            "Berries",
            "Apple",
            "Plums",
            "Avocados",
            "Watermelon"
        )
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        dataList = arrayListOf<DataClass>()
        getData()








    }
    private fun getData(){
        for(i in imageList.indices){
            val dataClass = DataClass(imageList[i],titleList[i])
            dataList.add(dataClass)

        }
        recyclerView.adapter = AdapterClass(dataList)
    }
}