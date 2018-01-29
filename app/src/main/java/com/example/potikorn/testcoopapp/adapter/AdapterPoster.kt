package com.example.potikorn.testcoopapp.adapter
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.potikorn.testcoopapp.R
import com.example.potikorn.testcoopapp.holder.MovieViewHolder
import com.example.potikorn.testcoopapp.models.Movie
import com.example.potikorn.testcoopapp.network.BaseUrl
import kotlinx.android.synthetic.main.list_item_movie.view.*

class AdapterPoster(private var movies: List<Movie>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    fun setItem(items: List<Movie>) {
        movies = items
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return MovieViewHolder(view)
    }
    override fun getItemCount(): Int = movies.size

    override fun getItemViewType(position: Int): Int = R.layout.list_item_movie

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        return (holder as MovieViewHolder).onBind(movies[position])
    }
}