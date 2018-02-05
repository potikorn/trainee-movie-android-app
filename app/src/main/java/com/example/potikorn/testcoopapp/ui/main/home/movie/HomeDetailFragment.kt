package com.example.potikorn.testcoopapp.ui.main.home.movie

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.potikorn.testcoopapp.R
import com.example.potikorn.testcoopapp.load
import com.example.potikorn.testcoopapp.models.movie.Movie
import com.example.potikorn.testcoopapp.models.movie.MovieList
import com.example.potikorn.testcoopapp.network.BaseUrl
import kotlinx.android.synthetic.main.fragmen_home_detail.*
import kotlinx.android.synthetic.main.list_item_movie.view.*
import kotlin.properties.Delegates

class HomeDetailFragment : Fragment(), HomeDetailFragmentContract.View {

    val intheaterAdapter: InTheaterAdapter by lazy { InTheaterAdapter() }
    val presenter: HomeDetailFragmentPresenter by lazy { HomeDetailFragmentPresenter(this) }

    companion object {
        fun newInstance(bundle: Bundle? = null) = HomeDetailFragment().apply {
            val inTheaterFragment = HomeDetailFragment()
            inTheaterFragment.arguments = bundle
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragmen_home_detail, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvInTheater.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = intheaterAdapter
        }
        presenter.apply {
            progressBar.visibility = View.VISIBLE
            requestInTheater()
        }
    }

    override fun getInTheaterData(dataList: MovieList) {
        progressBar.visibility = View.GONE
        intheaterAdapter.items = dataList.results?.toMutableList() ?: mutableListOf()
    }

    inner class InTheaterAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

        var items: MutableList<Movie> by Delegates.observable(mutableListOf(), { _, _, _ -> notifyDataSetChanged() })

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
            val view = LayoutInflater.from(context).inflate(R.layout.list_item_movie, parent, false)
            return InTheaterViewHolder(view)
        }

        override fun getItemCount(): Int = items.size

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
            return (holder as InTheaterViewHolder).onBind(items[position])
        }

        inner class InTheaterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            fun onBind(item: Movie) {
                itemView.imagePoster.load("${BaseUrl.baseUrlImageMovie}${item.poster}")
            }
        }
    }
}
