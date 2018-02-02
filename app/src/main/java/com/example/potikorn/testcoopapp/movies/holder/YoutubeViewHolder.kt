package com.example.potikorn.testcoopapp.movies.holder

import android.content.Intent
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.potikorn.testcoopapp.MainNavigation
import com.example.potikorn.testcoopapp.R
import com.example.potikorn.testcoopapp.load
import com.example.potikorn.testcoopapp.models.YouVidData
import kotlinx.android.synthetic.main.fuck_tube.view.*

class YoutubeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun onBind(television: YouVidData) {
        itemView.apply {
            tvYoutube.text = television.listData.title
            ivYou.load(MainNavigation.YOU_HEAD_PATH+television.id.videoId+MainNavigation.YOU_TAIL)
            setOnClickListener {
                itemView.context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(itemView.context.getString(R.string.youtube_url) + television.id.videoId)))
            } } }
}