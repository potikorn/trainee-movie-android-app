package com.example.potikorn.testcoopapp.holder

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.Glide
import com.example.potikorn.testcoopapp.DetailsMovie
import com.example.potikorn.testcoopapp.DetailsTelevision
import com.example.potikorn.testcoopapp.models.Television
import com.example.potikorn.testcoopapp.network.BaseUrl
import kotlinx.android.synthetic.main.list_item_movie.view.*

class TelevisionViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun onBind(television: Television) {
        itemView.title.text = television.name
        itemView.rating.text = television.vote_average
        itemView.ratingBar.rating = television.vote_average.toFloat().div(3)
        Glide.with(itemView.context).load(BaseUrl.baseUrlImageMovie+television.poster_path).into(itemView.TV)
        itemView.movies_layout.setOnClickListener {
            itemView.context.startActivity(Intent(itemView.context , DetailsTelevision::class.java).putExtra(DetailsMovie.Key, television))
    }
}
}