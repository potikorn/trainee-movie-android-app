package com.example.potikorn.testcoopapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.OrientationHelper
import com.bumptech.glide.Glide
import com.example.potikorn.testcoopapp.adapter.AdapterYoutube
import com.example.potikorn.testcoopapp.contracter.MainContractor
import com.example.potikorn.testcoopapp.models.Movie
import com.example.potikorn.testcoopapp.models.Television
import com.example.potikorn.testcoopapp.models.YouVidData
import com.example.potikorn.testcoopapp.network.BaseUrl
import com.example.potikorn.testcoopapp.presenter.YoutubePresenter
import kotlinx.android.synthetic.main.activity_details_movie.*

class DetailsMovie : AppCompatActivity(),MainContractor.View {
    private val adapterYoutube: AdapterYoutube by lazy { AdapterYoutube(listOf()) }
    private val presenter: MainContractor.Presenter? by lazy { YoutubePresenter(this) }

    override fun callBackData(arr: List<Movie>?, arrTv: List<Television>?, resultsYoutube: List<YouVidData>?) {
        resultsYoutube?.let { adapterYoutube.setItem(it) }
    }
    companion object {
        const val Key = "KEY_DATA"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_movie)
        val movie: Movie = intent.getParcelableExtra(Key)
        presenter?.callBackData(movie.title)
        youtubeList.apply {
            layoutManager = LinearLayoutManager(context, OrientationHelper.HORIZONTAL, false)
            adapter = adapterYoutube
        }
        titleMovie.text = movie.title
        sub.text = movie.overview
        Glide.with(this).load(BaseUrl.baseUrlImageMovie + movie.backdrop).into(imageMoview)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}