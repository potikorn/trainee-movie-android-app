package com.example.potikorn.testcoopapp.holder

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.potikorn.testcoopapp.DetailsMovie
import com.example.potikorn.testcoopapp.DetailsTelevision
import com.example.potikorn.testcoopapp.load
import com.example.potikorn.testcoopapp.models.Television
import com.example.potikorn.testcoopapp.network.BaseUrl
import kotlinx.android.synthetic.main.list_item_movie.view.*

class TelevisionViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun onBind(television: Television) {
        itemView.apply {
            rating.text = television.vote_average
            rating.text = television.vote_average
            ratingBar.rating = television.vote_average.toFloat().div(3)
            TV.load(BaseUrl.baseUrlImageMovie + television.poster_path)
            movies_layout.setOnClickListener {
                itemView.context.startActivity(Intent(itemView.context, DetailsTelevision::class.java).putExtra(DetailsMovie.Key, television))
            }
        }
    }
}