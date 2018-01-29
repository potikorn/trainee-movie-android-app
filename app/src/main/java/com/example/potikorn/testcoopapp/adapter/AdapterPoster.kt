package com.example.potikorn.testcoopapp.adapter
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.potikorn.testcoopapp.R
import com.example.potikorn.testcoopapp.models.Movie
import com.example.potikorn.testcoopapp.network.BaseUrl
import kotlinx.android.synthetic.main.list_item_movie.view.*

class AdapterPoster(var movies: List<Movie>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var callback: MovieListListener? = null
    interface MovieListListener {
        fun onClick(movie: Movie)
    }
    fun setOnClickCallback(callBack: MovieListListener) {
        this.callback = callBack
    }
    fun setItem(items: List<Movie>) {
        movies = items
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return MovieViewHolder(view)
    }
    override fun getItemCount(): Int {
        return movies.size
    }
    override fun getItemViewType(position: Int): Int {
        return R.layout.list_item_movie

    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        return (holder as MovieViewHolder).onBindata(movies.get(position))
    }
    inner class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun onBindata(movie: Movie) {
            itemView.title.setText(movie.title)
            itemView.rating.setText(movie.vote_average.toString())
            itemView.ratingBar.rating = movie.vote_average?.toFloat()!!.div(3)
            Glide.with(itemView.context).load(BaseUrl.baseUrlImageMovie+movie.poster).into(itemView.TV)
            itemView.TV.setOnClickListener {
                callback?.onClick(movie) } } }
}