package com.example.potikorn.testcoopapp.television.holder

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import com.example.potikorn.testcoopapp.DetailsMovie
import com.example.potikorn.testcoopapp.DetailsTelevision
import com.example.potikorn.testcoopapp.load
import com.example.potikorn.testcoopapp.models.television.Television
import com.example.potikorn.testcoopapp.network.BaseUrl
import kotlinx.android.synthetic.main.list_item_movie.view.*

class TelevisionViewHolderTop(view: View) : RecyclerView.ViewHolder(view) {

    fun onBind(television: Television) {
        Log.e("apkwfp" , television.toString())
        itemView.apply {
            TV.load(BaseUrl.baseUrlImageMovie + television.poster_path)
            movies_layout.setOnClickListener {
                itemView.context.startActivity(Intent(itemView.context, DetailsTelevision::class.java).putExtra(DetailsMovie.Key, television))
            } } }
}