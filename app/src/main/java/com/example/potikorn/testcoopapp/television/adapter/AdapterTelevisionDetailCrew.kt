package com.example.potikorn.testcoopapp.television.adapter

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.potikorn.testcoopapp.R
import com.example.potikorn.testcoopapp.models.Crew
import com.example.potikorn.testcoopapp.television.holder.TelevisionViewHolderDetailCrew

class AdapterTelevisionDetailCrew(private var creditActor: List<Crew>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    fun setItem(items: List<Crew>) {
        Log.e("crew sett ", items.toString())
        creditActor = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return TelevisionViewHolderDetailCrew(view)
    }

    override fun getItemCount(): Int = creditActor.size

    override fun getItemViewType(position: Int): Int = R.layout.credit_item

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) = (holder as TelevisionViewHolderDetailCrew).onBind(creditActor[position])
}