package com.example.potikorn.testcoopapp.movies

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.OrientationHelper
import com.example.potikorn.testcoopapp.R
import com.example.potikorn.testcoopapp.contactor.MainContractor
import com.example.potikorn.testcoopapp.load
import com.example.potikorn.testcoopapp.models.YouVidData
import com.example.potikorn.testcoopapp.models.movie.Movie
import com.example.potikorn.testcoopapp.models.television.Television
import com.example.potikorn.testcoopapp.movies.adapter.AdapterYoutube
import com.example.potikorn.testcoopapp.movies.presenter.YoutubePresenter
import com.example.potikorn.testcoopapp.network.BaseUrl
import kotlinx.android.synthetic.main.activity_details_theme.*

class DetailsMovie : AppCompatActivity(), MainContractor.View {
    private val adapterYoutube: AdapterYoutube by lazy { AdapterYoutube(listOf()) }
    private val presenter: MainContractor.Presenter? by lazy { YoutubePresenter(this) }

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
        youtubeList.apply {
            layoutManager = LinearLayoutManager(context, OrientationHelper.HORIZONTAL, false)
            adapter = adapterYoutube
        }
        titleMovie.text = movie.title
        sub.text = movie.overview
        imageMovie.load(BaseUrl.baseUrlImageMovie + movie.backdrop)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}