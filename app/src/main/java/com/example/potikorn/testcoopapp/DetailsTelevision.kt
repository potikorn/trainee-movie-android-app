package com.example.potikorn.testcoopapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.OrientationHelper
import com.example.potikorn.testcoopapp.contactor.MainContractor
import com.example.potikorn.testcoopapp.contactor.TelevisionFragmentContractor
import com.example.potikorn.testcoopapp.models.CreditActor
import com.example.potikorn.testcoopapp.models.Crew
import com.example.potikorn.testcoopapp.models.YouVidData
import com.example.potikorn.testcoopapp.models.movie.Movie
import com.example.potikorn.testcoopapp.models.television.Television
import com.example.potikorn.testcoopapp.models.television.TelevisionType
import com.example.potikorn.testcoopapp.movies.adapter.AdapterYoutube
import com.example.potikorn.testcoopapp.movies.presenter.YoutubePresenter
import com.example.potikorn.testcoopapp.network.BaseUrl
import com.example.potikorn.testcoopapp.television.adapter.AdapterTelevisionDetailActor
import com.example.potikorn.testcoopapp.television.adapter.AdapterTelevisionDetailCrew
import com.example.potikorn.testcoopapp.television.presenter.TvFragmentPresenter
import kotlinx.android.synthetic.main.activity_details_theme.*


@SuppressLint("Registered")
class DetailsTelevision : AppCompatActivity(), MainContractor.View, TelevisionFragmentContractor.View {
    private val adapterYoutube: AdapterYoutube by lazy { AdapterYoutube(listOf()) }
    private val actorAdapter: AdapterTelevisionDetailActor by lazy { AdapterTelevisionDetailActor(listOf()) }
    private val crewAdapter: AdapterTelevisionDetailCrew by lazy { AdapterTelevisionDetailCrew(listOf()) }
    private val presenter: MainContractor.Presenter? by lazy { YoutubePresenter(this) }
    private val tvPresenter: TelevisionFragmentContractor.Presenter by lazy { TvFragmentPresenter(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_theme)
        val television: Television = intent.getParcelableExtra(DetailsMovie.Key)
        presenter?.callBackData(television.name)
        tvPresenter.callActor(television.id)
        tvPresenter.callCrew(television.id)
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
        titleMovie.text = television.name
        sub.text = television.overview
        imageMovie.load(BaseUrl.baseUrlImageMovie + television.backdrop_path)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun callBackData(arr: List<Movie>?, arrTv: List<Television>?, resultsYoutube: List<YouVidData>?) {
        resultsYoutube?.let { adapterYoutube.setItem(it) }
    }


    override fun callCrew(arrActor: List<Crew>?) {
        arrActor?.let { it -> crewAdapter.setItem(it) }
    }

    override fun callCredit(arrActor: List<CreditActor>?) {
        arrActor?.let { it -> actorAdapter.setItem(it) }
    }

    override fun callbackGenres(arrTv: List<TelevisionType>?) {
    }

    override fun callBackPopularData(arrTv: List<Television>?) {
    }

    override fun callTopRateData(arrTv: List<Television>?) {
    }
}