package com.example.potikorn.testcoopapp.movies.holder
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.potikorn.testcoopapp.movies.DetailsMovie
import com.example.potikorn.testcoopapp.load
import com.example.potikorn.testcoopapp.models.movie.Movie
import com.example.potikorn.testcoopapp.network.BaseUrl
import kotlinx.android.synthetic.main.list_item_movie_details.view.*

class MovieViewDetails(view: View) : RecyclerView.ViewHolder(view) {

    fun onBind(movie: Movie) {
        itemView.apply {
            title.text = movie.title
            rating.text = movie.vote_average.toString()
            ratingBar.rating = movie.vote_average?.toFloat()!!.div(3)
            movies_layout.setOnClickListener {
                itemView.context.startActivity(Intent(
                        itemView.context,
                        DetailsMovie::class.java
                ).putExtra(DetailsMovie.Key, movie))
            }
            TV.load(BaseUrl.baseUrlImageMovie + movie.poster)
        }
    }
}
