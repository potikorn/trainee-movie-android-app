package com.example.potikorn.testcoopapp.movies.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.potikorn.testcoopapp.models.movie.MovieType
import kotlinx.android.synthetic.main.genres_item.view.*


class MovieViewHolderGenres (view: View) : RecyclerView.ViewHolder(view) {

    fun onBind(television: MovieType) {
        itemView.apply {
            genresName.text = television.type_name
        }
    }
}