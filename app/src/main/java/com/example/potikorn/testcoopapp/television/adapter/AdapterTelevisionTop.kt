package com.example.potikorn.testcoopapp.television.adapter

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.potikorn.testcoopapp.R
import com.example.potikorn.testcoopapp.models.television.Television
import com.example.potikorn.testcoopapp.television.holder.TelevisionViewHolderTop

class AdapterTelevisionTop(private var television: List<Television>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    fun setItem(items: List<Television>) {
        television = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return TelevisionViewHolderTop(view)
    }

    override fun getItemCount(): Int {
        return when(television.isNotEmpty()){
            true->5
            false->television.size
        }
    }

    override fun getItemViewType(position: Int): Int = R.layout.list_item_movie

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) = (holder as TelevisionViewHolderTop).onBind(television[position])
}