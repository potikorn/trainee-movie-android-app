package com.example.potikorn.testcoopapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.potikorn.testcoopapp.contactor.MovieFragmentContractor
import com.example.potikorn.testcoopapp.models.CreditActor
import com.example.potikorn.testcoopapp.models.Crew
import com.example.potikorn.testcoopapp.models.movie.Movie
import com.example.potikorn.testcoopapp.models.movie.MovieType
import com.example.potikorn.testcoopapp.movies.adapter.AdapterDetails
import com.example.potikorn.testcoopapp.movies.holder.MovieViewHolderGenres
import com.example.potikorn.testcoopapp.movies.presenter.GenresDetailPresenter
import kotlinx.android.synthetic.main.activity_genres_show_detail.*

class GenresShowDetailActivity : AppCompatActivity(), MovieFragmentContractor.View {
    override fun callCredit(arrActor: List<CreditActor>?) {

    }

    override fun callCrew(arrActor: List<Crew>?) {
    }

    private val myAdapter: AdapterDetails by lazy { AdapterDetails(listOf()) }
    private val presenter: MovieFragmentContractor.Presenter? by lazy { GenresDetailPresenter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_genres_show_detail)
        val genresId = intent.getStringExtra(MovieViewHolderGenres.KEY_GENRES)
        presenter?.topRateData(genresId)
        genresDetailList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = myAdapter
        }
    }

    override fun callbackGenres(arrMovie: List<MovieType>?) {
    }

    override fun callBackPopularData(arrMovie: List<Movie>?) {
    }

    override fun callTopRateData(arrMovie: List<Movie>?) {
        arrMovie?.let { it->myAdapter.setItem(it) }
    }
}
