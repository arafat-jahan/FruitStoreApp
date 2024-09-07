package com.example.recycleviewassignment

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList: ArrayList<DataClass>
    private lateinit var imageList: Array<Int>
     private lateinit var titleList:Array<String>
     private lateinit var searchView: SearchView
     private lateinit var searchList: ArrayList<DataClass>


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
        searchView =  findViewById(R.id.search)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        searchList = arrayListOf<DataClass>()
        getData()
        searchView.clearFocus()
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
               searchView.clearFocus()
                return true

            }

            override fun onQueryTextChange(newText: String?): Boolean {
              searchList.clear()
                val searchText = newText!!.toLowerCase(Locale.getDefault())
                if(searchText.isNotEmpty()){
                    dataList.forEach{
                        if(it.dataTitle.toLowerCase(Locale.getDefault()).contains(searchText)){
                            searchList.add(it)
                        }
                    }

recyclerView.adapter!!.notifyDataSetChanged()
                }else{
                  searchList.clear()
                    searchList.addAll(dataList)
                    recyclerView.adapter!!.notifyDataSetChanged()

                }
                return false
            }

        })











    }
    private fun getData(){
        for(i in imageList.indices){
            val dataClass = DataClass(imageList[i],titleList[i])
            dataList.add(dataClass)

        }
        searchList.addAll(dataList)
        recyclerView.adapter = AdapterClass(searchList)
    }
}