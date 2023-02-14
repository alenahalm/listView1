package com.example.myapplication3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyRecycleViewAdapter(val list: List<MainActivity.Person>) : RecyclerView.Adapter<MyRecycleViewAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.counter.text = ""
        if (position % 3 == 0) {
            holder.counter.text = position.toString()
        }
        holder.firstname.text = list[position].name
        holder.lastname.text = list[position].surname
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MyViewHolder(val itemView: View) : RecyclerView.ViewHolder(itemView) {
        var counter: TextView
        var firstname: TextView
        var lastname: TextView

        init {
            counter = itemView.findViewById(R.id.ItemNum)
            firstname = itemView.findViewById(R.id.ItemFirstname)
            lastname = itemView.findViewById(R.id.ItemLastname)
        }
    }
}