package com.example.potikorn.testcoopapp.movies

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.potikorn.testcoopapp.R
import com.example.potikorn.testcoopapp.contactor.MovieFragmentContractor
import com.example.potikorn.testcoopapp.models.CreditActor
import com.example.potikorn.testcoopapp.models.Crew
import com.example.potikorn.testcoopapp.models.movie.Movie
import com.example.potikorn.testcoopapp.models.movie.MovieType
import com.example.potikorn.testcoopapp.movies.adapter.AdapterDetails
import com.example.potikorn.testcoopapp.movies.holder.MovieViewHolderGenres
import com.example.potikorn.testcoopapp.movies.presenter.DetailGenresPresenter
import kotlinx.android.synthetic.main.activity_show_detail_genres.*

class ShowDetailGenresActivity : AppCompatActivity(), MovieFragmentContractor.View {
    override fun callCredit(arrActor: List<CreditActor>?) {

    }

    override fun callCrew(arrActor: List<Crew>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private val myAdapter: AdapterDetails by lazy { AdapterDetails(listOf()) }
    private val presenter: MovieFragmentContractor.Presenter? by lazy { DetailGenresPresenter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_detail_genres)
        val key = intent.getStringExtra(MovieViewHolderGenres.KEY_GENRES)
        presenter?.topRateData(key)
        detailGenres.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = myAdapter
        }
    }

    override fun callbackGenres(arrMovie: List<MovieType>?) {

    }

    override fun callBackPopularData(arrMovie: List<Movie>?) {
    }

    override fun callTopRateData(arrMovie: List<Movie>?) {
        arrMovie?.let { it -> myAdapter.setItem(it) }
    }
}
