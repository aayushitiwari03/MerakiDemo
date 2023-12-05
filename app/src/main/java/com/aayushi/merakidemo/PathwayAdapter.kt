package com.aayushi.merakidemo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PathwayAdapter(private val context: Context, private var pathwayList: List<Pathway>): RecyclerView.Adapter<PathwayAdapter.PathwayViewHolder>() {



    class PathwayViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val name : TextView = itemView.findViewById(R.id.name)
        val logo : ImageView = itemView.findViewById(R.id.pathway_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PathwayViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pathway_list_item, parent, false)
        return PathwayViewHolder(view)
    }

    override fun getItemCount(): Int {
        return pathwayList.size
    }

    override fun onBindViewHolder(holder: PathwayViewHolder, position: Int) {
        val currentItem = pathwayList[position]
        holder.name.text = currentItem.name
        Glide.with(holder.logo.context).load(currentItem.logo).into(holder.logo)
    }

}