package com.example.potikorn.testcoopapp.holder

import android.content.Intent
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.View
import com.bumptech.glide.Glide
import com.example.potikorn.testcoopapp.R
import com.example.potikorn.testcoopapp.models.YouVidData
import kotlinx.android.synthetic.main.fuck_tube.view.*

class YoutubeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun onBind(television: YouVidData) {
        itemView.apply {
            tvYoutube.text=television.listData.title
            Glide.with(itemView.context).load("https://i.ytimg.com/vi/${television.id.videoId}/mqdefault.jpg").into(ivYou)
        }
        itemView.setOnClickListener {
            itemView.context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(itemView.context.getString(R.string.youtube_url) + television.id.videoId)))
        }
}
}