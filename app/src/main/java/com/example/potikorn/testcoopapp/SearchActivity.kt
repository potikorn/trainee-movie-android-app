package com.example.potikorn.testcoopapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.KeyEvent
import com.example.potikorn.testcoopapp.adapter.AdapterPoster
import com.example.potikorn.testcoopapp.contracter.MainContractor
import com.example.potikorn.testcoopapp.models.movie.Movie
import com.example.potikorn.testcoopapp.models.television.Television
import com.example.potikorn.testcoopapp.models.YouVidData
import com.example.potikorn.testcoopapp.presenter.SearchPresenter
import kotlinx.android.synthetic.main.activity_search.*

@Suppress("DEPRECATED_IDENTITY_EQUALS")
class SearchActivity : AppCompatActivity(), MainContractor.View {
    private val searchPresenter: MainContractor.Presenter = SearchPresenter(this)
    private val movieAdapter: AdapterPoster by lazy { AdapterPoster(listOf()) }

    override fun callBackData(arr: List<Movie>?, arrTv: List<Television>?, resultsYoutube: List<YouVidData>?) {
        arr?.let { movieAdapter.setItem(it) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        resultList?.layoutManager = LinearLayoutManager(this)
        resultList.adapter = movieAdapter
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        etSearch.setOnKeyListener { _, keyCode, keyEvent ->
            if (keyEvent.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                searchPresenter.callBackData(etSearch.text.toString())
                true
            } else false
        }
    }
}