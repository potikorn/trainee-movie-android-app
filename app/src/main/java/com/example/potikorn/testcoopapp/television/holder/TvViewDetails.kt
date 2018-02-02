package com.example.potikorn.testcoopapp.television.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.potikorn.testcoopapp.load
import com.example.potikorn.testcoopapp.models.television.Television
import com.example.potikorn.testcoopapp.network.BaseUrl
import kotlinx.android.synthetic.main.list_item_movie_details.view.*

class TvViewDetails (view: View) : RecyclerView.ViewHolder(view) {

    fun onBind(tv: Television) {
        itemView.apply {
            title.text = tv.name
            rating.text = tv.vote_average
            ratingBar.rating = tv.vote_average?.toFloat()!!.div(3)
            movies_layout.setOnClickListener {

            }
            TV.load(BaseUrl.baseUrlImageMovie + tv.poster_path)
        }
    }



}