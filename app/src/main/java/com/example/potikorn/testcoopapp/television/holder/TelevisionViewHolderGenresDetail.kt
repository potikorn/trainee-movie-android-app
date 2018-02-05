package com.example.potikorn.testcoopapp.television.holder

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.potikorn.testcoopapp.DetailsMovie
import com.example.potikorn.testcoopapp.DetailsTelevision
import com.example.potikorn.testcoopapp.load
import com.example.potikorn.testcoopapp.models.television.Television
import com.example.potikorn.testcoopapp.network.BaseUrl
import kotlinx.android.synthetic.main.list_item_movie_details.view.*

class TelevisionViewHolderGenresDetail(view: View) : RecyclerView.ViewHolder(view) {

    fun onBind(television: Television) {
        itemView.apply {
            title.text = television.name
            rating.text = television.vote_average
            ratingBar.rating = television.vote_average?.toFloat()!!.div(3)
            setOnClickListener { itemView.context.startActivity(Intent(itemView.context, DetailsTelevision::class.java).putExtra(DetailsMovie.Key, television)) }
            tvPosterDetail.load(BaseUrl.baseUrlImageMovie + television.poster_path)
        }
    }
}