package com.example.jkfb_webrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WebsiteAdapter(private val websites: List<Website>, private val listener: OnItemClickListener) : RecyclerView.Adapter<WebsiteAdapter.ViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(website: Website)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_1, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val website = websites[position]
        holder.textView.text = website.name
        holder.itemView.setOnClickListener {
            listener.onItemClick(website)
        }
    }

    override fun getItemCount(): Int {
        return websites.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(android.R.id.text1)
    }
}