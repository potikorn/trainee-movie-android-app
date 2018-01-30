package com.example.potikorn.testcoopapp.holder
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.Glide
import com.example.potikorn.testcoopapp.DetailsMovie
import com.example.potikorn.testcoopapp.models.Movie
import com.example.potikorn.testcoopapp.network.BaseUrl
import kotlinx.android.synthetic.main.list_item_movie.view.*

class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun onBind(movie: Movie) {
        itemView.title.text = movie.title
        itemView.rating.text = movie.vote_average.toString()
        itemView.ratingBar.rating = movie.vote_average?.toFloat()!!.div(3)
        Glide.with(itemView.context).load(BaseUrl.baseUrlImageMovie+movie.poster).into(itemView.TV)
        itemView.movies_layout.setOnClickListener {
            itemView.context.startActivity(Intent(itemView.context , DetailsMovie::class.java).putExtra(DetailsMovie.Key, movie))
        } }
}