package com.example.potikorn.testcoopapp.movies.holder

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.potikorn.testcoopapp.DetailsMovie
import com.example.potikorn.testcoopapp.load
import com.example.potikorn.testcoopapp.models.movie.Movie
import com.example.potikorn.testcoopapp.network.BaseUrl
import kotlinx.android.synthetic.main.list_item_movie.view.*

class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun onBind(movie: Movie) {
        itemView.apply {
            movies_layout.setOnClickListener {
                itemView.context.startActivity(Intent(
                        itemView.context,
                        DetailsMovie::class.java
                ).putExtra(DetailsMovie.Key, movie))
            }
            imagePoster.load(BaseUrl.baseUrlImageMovie + movie.poster)
        }
    }
}