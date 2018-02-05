package com.example.potikorn.testcoopapp.television.holder

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.potikorn.testcoopapp.models.television.TelevisionType
import com.example.potikorn.testcoopapp.television.GenresTelevisionDetailActivity
import kotlinx.android.synthetic.main.genres_item.view.*

class TelevisionViewHolderGenres(view: View) : RecyclerView.ViewHolder(view) {
companion object {
    const val KEY_GENRES = "GEN"
}

    fun onBind(television: TelevisionType) {
        itemView.apply {
            genresName.text = television.type_name
            setOnClickListener {
                context.startActivity(Intent(context,GenresTelevisionDetailActivity::class.java).putExtra(KEY_GENRES,television.type_id))
            }
        }
    }
}