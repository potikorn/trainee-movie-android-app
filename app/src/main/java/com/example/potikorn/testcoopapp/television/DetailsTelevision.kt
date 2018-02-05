package com.example.potikorn.testcoopapp.television

import android.annotation.SuppressLint
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
import com.example.potikorn.testcoopapp.movies.DetailsMovie
import com.example.potikorn.testcoopapp.movies.adapter.AdapterYoutube
import com.example.potikorn.testcoopapp.movies.presenter.YoutubePresenter
import com.example.potikorn.testcoopapp.network.BaseUrl
import kotlinx.android.synthetic.main.activity_details_theme.*


@SuppressLint("Registered")
class DetailsTelevision : AppCompatActivity(), MainContractor.View {

    private val adapterYoutube: AdapterYoutube by lazy { AdapterYoutube(listOf()) }
    private val presenter: MainContractor.Presenter? by lazy { YoutubePresenter(this) }


    override fun callBackData(arr: List<Movie>?, arrTv: List<Television>?, resultsYoutube: List<YouVidData>?) {
        resultsYoutube?.let { adapterYoutube.setItem(it) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_theme)
        val television: Television = intent.getParcelableExtra(DetailsMovie.Key)
        presenter?.callBackData(television.name)
        youtubeList.apply {
            layoutManager = LinearLayoutManager(context, OrientationHelper.HORIZONTAL, false)
            adapter = adapterYoutube
        }
        titleMovie.text = television.name
        sub.text = television.overview
        imageMovie.load(BaseUrl.baseUrlImageMovie + television.backdrop_path)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}