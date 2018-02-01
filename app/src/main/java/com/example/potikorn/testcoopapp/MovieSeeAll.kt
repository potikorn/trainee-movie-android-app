package com.example.potikorn.testcoopapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.potikorn.testcoopapp.adapter.AdapterDetails
import com.example.potikorn.testcoopapp.contracter.MainContractor
import com.example.potikorn.testcoopapp.models.YouVidData
import com.example.potikorn.testcoopapp.models.movie.Movie
import com.example.potikorn.testcoopapp.models.television.Television
import com.example.potikorn.testcoopapp.presenter.MainPresenter
import kotlinx.android.synthetic.main.fragment_theme.*

class MovieSeeAll : AppCompatActivity(), MainContractor.View {
    private val movieAdapter: AdapterDetails by lazy { AdapterDetails(listOf()) }
    private var presenter: MainContractor.Presenter? = MainPresenter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(R.layout.activity_details_type_movie)
        televisionList?.layoutManager = LinearLayoutManager(this)
        televisionList.adapter = movieAdapter
        presenter?.callBackData()
    }

    override fun callBackData(arr: List<Movie>?, arrTv: List<Television>?, resultsYoutube: List<YouVidData>?) {
        arr?.let { movieAdapter.setItem(it) }
    }
}