package com.example.potikorn.testcoopapp.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.potikorn.testcoopapp.R
import com.example.potikorn.testcoopapp.holder.TelevisionViewHolder
import com.example.potikorn.testcoopapp.models.Television

class AdapterTelevision(private var television: List<Television>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    fun setItem(items: List<Television>) {
        television = items
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return TelevisionViewHolder(view)
    }
    override fun getItemCount(): Int = television.size

    override fun getItemViewType(position: Int): Int = R.layout.list_item_movie

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        return (holder as TelevisionViewHolder).onBind(television[position])
    }
}