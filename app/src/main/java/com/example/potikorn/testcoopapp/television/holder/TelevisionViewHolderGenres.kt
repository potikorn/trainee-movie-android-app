package com.example.potikorn.testcoopapp.television.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.potikorn.testcoopapp.models.television.TelevisionType
import kotlinx.android.synthetic.main.genres_item.view.*

class TelevisionViewHolderGenres(view: View) : RecyclerView.ViewHolder(view) {

    fun onBind(television: TelevisionType) {
        itemView.apply {
            genresName.text = television.type_name
        }
    }
}