package com.example.potikorn.testcoopapp.movies.adapter
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.potikorn.testcoopapp.R
import com.example.potikorn.testcoopapp.movies.holder.MovieViewHolderGenres
import com.example.potikorn.testcoopapp.models.movie.MovieType

class AdapterMovieGenres(private var movie: List<MovieType>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    fun setItem(items: List<MovieType>) {
        movie = items
        notifyDataSetChanged() }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return MovieViewHolderGenres(view) }

    override fun getItemCount(): Int = movie.size

    override fun getItemViewType(position: Int): Int = R.layout.genres_item

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) = (holder as MovieViewHolderGenres).onBind(movie[position])
}