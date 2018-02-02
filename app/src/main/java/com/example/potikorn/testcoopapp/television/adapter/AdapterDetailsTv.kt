package com.example.potikorn.testcoopapp.television.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.potikorn.testcoopapp.R
import com.example.potikorn.testcoopapp.models.television.Television
import com.example.potikorn.testcoopapp.television.holder.TvViewDetails

class AdapterDetailsTv (private var tv: List<Television>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    fun setItem(items: List<Television>) {
        tv = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return TvViewDetails(view)
    }

    override fun getItemCount(): Int = tv.size

    override fun getItemViewType(position: Int): Int = R.layout.list_item_movie_details

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) = (holder as TvViewDetails).onBind(tv[position])
}