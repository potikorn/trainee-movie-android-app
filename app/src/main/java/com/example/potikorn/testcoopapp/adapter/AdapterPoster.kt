package com.example.potikorn.testcoopapp.adapter
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.potikorn.testcoopapp.R
import com.example.potikorn.testcoopapp.models.Movie
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
        if (viewType == R.layout.list_item_movie) {
            return MovieViewHolder(view)
        }else if(viewType == R.layout.list_item_movie){
            return MovieViewHolder2(view)
        } else {
            return MovieViewHolder3(view)
        }
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun getItemViewType(position: Int): Int {
        if (position == 0) {
            return R.layout.recyclerview_desing
        }else{
            return R.layout.list_item_movie
        }

    }

    inner class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun onBindata(movie: Movie) {
            itemView.title.setText(movie.title)
            itemView.rating.setText(movie.vote_average.toString())
            itemView.ratingBar.rating = movie.vote_average?.toFloat()!!.div(3)
            Glide.with(itemView.context)
                    .load("URL" + movie.poster)
                    .into(itemView.TV)
            itemView.TV.setOnClickListener {
                //callback?.onClick(movie)
            } }
    }
    inner class MovieViewHolder2(view: View) : RecyclerView.ViewHolder(view) {
        fun onBindata2(movie: Movie) {
        }
    }
    inner class MovieViewHolder3(view: View):RecyclerView.ViewHolder(view){
        fun  onBindata(movie: Movie){
        }
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        if (holder is MovieViewHolder2) {
            return (holder as MovieViewHolder2).onBindata2(movies.get(position))
        } else if(holder is MovieViewHolder) {
            return (holder as MovieViewHolder).onBindata(movies.get(position))
        }else{
            return (holder as MovieViewHolder3).onBindata(movies.get(position))
        } }

}