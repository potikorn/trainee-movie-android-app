package com.example.potikorn.testcoopapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.OrientationHelper
import com.example.potikorn.testcoopapp.contactor.MainContractor
import com.example.potikorn.testcoopapp.contactor.MovieFragmentContractor
import com.example.potikorn.testcoopapp.models.CreditActor
import com.example.potikorn.testcoopapp.models.Crew
import com.example.potikorn.testcoopapp.models.YouVidData
import com.example.potikorn.testcoopapp.models.movie.Movie
import com.example.potikorn.testcoopapp.models.movie.MovieType
import com.example.potikorn.testcoopapp.models.television.Television
import com.example.potikorn.testcoopapp.movies.adapter.AdapterYoutube
import com.example.potikorn.testcoopapp.movies.presenter.MovieFragmentPresenter
import com.example.potikorn.testcoopapp.movies.presenter.YoutubePresenter
import com.example.potikorn.testcoopapp.network.BaseUrl
import com.example.potikorn.testcoopapp.television.adapter.AdapterTelevisionDetailActor
import com.example.potikorn.testcoopapp.television.adapter.AdapterTelevisionDetailCrew
import kotlinx.android.synthetic.main.activity_details_theme.*

class DetailsMovie : AppCompatActivity(), MainContractor.View, MovieFragmentContractor.View {
    override fun callbackGenres(arrMovie: List<MovieType>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun callBackPopularData(arrMovie: List<Movie>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun callTopRateData(arrMovie: List<Movie>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private val adapterYoutube: AdapterYoutube by lazy { AdapterYoutube(listOf()) }
    private val actorAdapter: AdapterTelevisionDetailActor by lazy { AdapterTelevisionDetailActor(listOf()) }
    private val crewAdapter: AdapterTelevisionDetailCrew by lazy { AdapterTelevisionDetailCrew(listOf()) }
    private val presenter: MainContractor.Presenter? by lazy { YoutubePresenter(this) }
    private val moviePresenter: MovieFragmentContractor.Presenter by lazy { MovieFragmentPresenter(this) }

    companion object {

        const val Key = "KEY_DATA"
    }

    override fun callBackData(arr: List<Movie>?, arrTv: List<Television>?, resultsYoutube: List<YouVidData>?) {
        resultsYoutube?.let(adapterYoutube::setItem)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_theme)
        val movie: Movie = intent.getParcelableExtra(Key)
        presenter?.callBackData(movie.title)
        moviePresenter.callActor(movie.id)
        moviePresenter.callCrew(movie.id)
        actorList.apply {
            layoutManager = LinearLayoutManager(context, OrientationHelper.HORIZONTAL, false)
            adapter = actorAdapter
        }
        crewList.apply {
            layoutManager = LinearLayoutManager(context, OrientationHelper.HORIZONTAL, false)
            adapter = crewAdapter
        }
        youtubeList.apply {
            layoutManager = LinearLayoutManager(context, OrientationHelper.HORIZONTAL, false)
            adapter = adapterYoutube
        }
        titleMovie.text = movie.title
        sub.text = movie.overview
        imageMovie.load(BaseUrl.baseUrlImageMovie + movie.backdrop)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun callCredit(arrActor: List<CreditActor>?) {
        arrActor?.let { it -> actorAdapter.setItem(it) }
    }

    override fun callCrew(arrActor: List<Crew>?) {
        arrActor?.let { it -> crewAdapter.setItem(it) }
    }
}