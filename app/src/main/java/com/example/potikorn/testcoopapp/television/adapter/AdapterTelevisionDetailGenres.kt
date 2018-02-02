package com.example.potikorn.testcoopapp.television.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.potikorn.testcoopapp.R
import com.example.potikorn.testcoopapp.models.television.Television
import com.example.potikorn.testcoopapp.television.holder.TelevisionViewHolderGenresDetail

class AdapterTelevisionDetailGenres(private var television: List<Television>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    fun setItem(items: List<Television>) {
        television = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return TelevisionViewHolderGenresDetail(view)
    }

    override fun getItemCount(): Int = television.size

    override fun getItemViewType(position: Int): Int = R.layout.list_item_movie_details

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) = (holder as TelevisionViewHolderGenresDetail).onBind(television[position])
}