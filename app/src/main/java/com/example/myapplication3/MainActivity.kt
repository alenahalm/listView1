package com.example.myapplication3

import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.BaseAdapter
import android.widget.ListView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray

class MainActivity : AppCompatActivity() {
    data class Person(val name: String, val surname: String)

    class VerticalDecor(val space: Int) : RecyclerView.ItemDecoration() {
        override fun getItemOffsets(outRect: Rect, itemPosition: Int, parent: RecyclerView) {
            outRect.bottom = space
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val content: String = assets.open("test.json").bufferedReader().use { it.readText() }
        val jsonArr = JSONArray(content)
        val people: MutableList<Person> = ArrayList(jsonArr.length())
        for (i in 0 until jsonArr.length()) {
            val obj = jsonArr.getJSONObject(i)
            val name = obj.getJSONObject("name")

            people.add(
                Person(
                    name.getString("firstname"),
                    name.getString("surname")
                )
            )
        }
//        val listView: ListView = findViewById(R.id.listView)
//        listView.adapter = MyListViewAdapter(people)

        val recyclerView: RecyclerView = findViewById(R.id.RecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.addItemDecoration(DividerItemDecoration(this, RecyclerView.VERTICAL))
        recyclerView.addItemDecoration(VerticalDecor(200))

        recyclerView.adapter = MyRecycleViewAdapter(people)
    }
}