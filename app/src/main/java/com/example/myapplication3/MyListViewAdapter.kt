package com.example.myapplication3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView


class MyListViewAdapter(val list: List<MainActivity.Person>) : BaseAdapter(){
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): MainActivity.Person {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, containerView: View?, parent: ViewGroup?): View {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item, parent, false)
        if (position % 3 == 0) {
            view.findViewById<TextView>(R.id.ItemNum).text = position.toString()
        }
//        view.findViewById<TextView>(R.id.ItemNum).text = position.toString()
        view.findViewById<TextView>(R.id.ItemFirstname).text = getItem(position).name
        view.findViewById<TextView>(R.id.ItemLastname).text = getItem(position).surname
        return view
    }

}