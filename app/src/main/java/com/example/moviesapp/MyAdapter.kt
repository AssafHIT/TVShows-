package com.example.moviesapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val showList : ArrayList<showCard>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.show_item,
            parent,false)
        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentitem = showList[position]

        holder.name.text = currentitem.name
        holder.language.text = currentitem.language
        holder.genres1.text = currentitem.genres1
        holder.genres2.text = currentitem.genres2
        holder.genres3.text = currentitem.genres3
        holder.runtime.text = currentitem.runtime.toString()
        holder.rating.text = currentitem.rating.toString()
    }

    override fun getItemCount(): Int {

        return showList.size
    }


    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val name : TextView = itemView.findViewById(R.id.name)
        val language : TextView = itemView.findViewById(R.id.language)
        val genres1 : TextView = itemView.findViewById(R.id.genres1)
        val genres2 : TextView = itemView.findViewById(R.id.genres2)
        val genres3 : TextView = itemView.findViewById(R.id.genres3)
        val runtime : TextView = itemView.findViewById(R.id.runtime)
        val rating : TextView = itemView.findViewById(R.id.rating)

    }

}