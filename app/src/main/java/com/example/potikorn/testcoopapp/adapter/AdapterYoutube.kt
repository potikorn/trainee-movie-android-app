package com.example.potikorn.testcoopapp.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.potikorn.testcoopapp.R
import com.example.potikorn.testcoopapp.holder.YoutubeViewHolder
import com.example.potikorn.testcoopapp.models.YouVidData

class AdapterYoutube(private var youtube: List<YouVidData>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    fun setItem(items: List<YouVidData>) {
        youtube = items
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return YoutubeViewHolder(view)
    }
    override fun getItemCount(): Int = youtube.size

    override fun getItemViewType(position: Int): Int = R.layout.fuck_tube

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int)= (holder as YoutubeViewHolder).onBind(youtube[position])
}