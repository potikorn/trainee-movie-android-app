package com.example.potikorn.testcoopapp.television.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.potikorn.testcoopapp.R
import com.example.potikorn.testcoopapp.models.television.Television
import com.example.potikorn.testcoopapp.models.television.TelevisionType
import com.example.potikorn.testcoopapp.television.holder.TelevisionViewHolderGenres

class AdapterTelevisionGenres(private var television: List<TelevisionType>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    fun setItem(items: List<TelevisionType>) {
        television = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return TelevisionViewHolderGenres(view)
    }

    override fun getItemCount(): Int {
        return when(television.isNotEmpty()){
            true->5
            false->television.size
        }
    }

    override fun getItemViewType(position: Int): Int = R.layout.genres_item

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) = (holder as TelevisionViewHolderGenres).onBind(television[position])
}