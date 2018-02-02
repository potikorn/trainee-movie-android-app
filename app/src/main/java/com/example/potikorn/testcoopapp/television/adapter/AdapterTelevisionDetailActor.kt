package com.example.potikorn.testcoopapp.television.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.potikorn.testcoopapp.R
import com.example.potikorn.testcoopapp.models.CreditActor
import com.example.potikorn.testcoopapp.television.holder.TelevisionViewHolderDetailActor

class AdapterTelevisionDetailActor(private var creditActor: List<CreditActor>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    fun setItem(items: List<CreditActor>) {
        creditActor = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return TelevisionViewHolderDetailActor(view)
    }

    override fun getItemCount(): Int = creditActor.size

    override fun getItemViewType(position: Int): Int = R.layout.credit_item

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) = (holder as TelevisionViewHolderDetailActor).onBind(creditActor[position])
}