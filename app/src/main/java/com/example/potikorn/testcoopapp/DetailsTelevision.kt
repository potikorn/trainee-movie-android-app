package com.example.potikorn.testcoopapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.OrientationHelper
import com.example.potikorn.testcoopapp.adapter.AdapterYoutube
import com.example.potikorn.testcoopapp.contracter.MainContractor
import com.example.potikorn.testcoopapp.models.movie.Movie
import com.example.potikorn.testcoopapp.models.television.Television
import com.example.potikorn.testcoopapp.models.YouVidData
import com.example.potikorn.testcoopapp.network.BaseUrl
import com.example.potikorn.testcoopapp.presenter.YoutubePresenter
import kotlinx.android.synthetic.main.activity_details_movie.*

@SuppressLint("Registered")
class DetailsTelevision : AppCompatActivity(), MainContractor.View {
    private val adapterYoutube: AdapterYoutube by lazy { AdapterYoutube(listOf()) }
    private val presenter: MainContractor.Presenter? by lazy { YoutubePresenter(this) }

    override fun callBackData(arr: List<Movie>?, arrTv: List<Television>?, resultsYoutube: List<YouVidData>?) {
        resultsYoutube?.let { adapterYoutube.setItem(it) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_movie)
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