package com.example.potikorn.testcoopapp.movies.holder

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.potikorn.testcoopapp.GenresShowDetailActivity
import com.example.potikorn.testcoopapp.models.movie.MovieType
import com.example.potikorn.testcoopapp.movies.ShowDetailGenresActivity
import kotlinx.android.synthetic.main.genres_item.view.*

class MovieViewHolderGenres(view: View) : RecyclerView.ViewHolder(view) {
companion object {
    const val KEY_GENRES = "GENRES"
}
    fun onBind(movie: MovieType) {
        itemView.apply {
            genresName.text = movie.type_name
            genresLayout.setOnClickListener {
                context.startActivity(Intent(context, GenresShowDetailActivity::class.java).putExtra(KEY_GENRES, movie.type_id))
            }}}}

