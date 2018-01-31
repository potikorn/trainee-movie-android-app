package com.example.potikorn.testcoopapp.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.potikorn.testcoopapp.R
import com.example.potikorn.testcoopapp.adapter.AdapterTelevision
import com.example.potikorn.testcoopapp.contracter.MainContractor
import com.example.potikorn.testcoopapp.models.YouVidData
import com.example.potikorn.testcoopapp.models.movie.Movie
import com.example.potikorn.testcoopapp.models.television.Television
import com.example.potikorn.testcoopapp.presenter.TelevisionPresenter
import kotlinx.android.synthetic.main.fragment_fragment_movie.*

class FragmentMovieTV : Fragment(), MainContractor.View {
    private val televisionAdapter: AdapterTelevision by lazy { AdapterTelevision(listOf()) }
    private val presenter: MainContractor.Presenter? by lazy { TelevisionPresenter(this) }

    override fun callBackData(arr: List<Movie>?, arrTv: List<Television>?, resultsYoutube: List<YouVidData>?) {
        arrTv?.let { it1 -> televisionAdapter.setItem(it1) }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_fragment_movie, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        moviesList?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        moviesList.adapter = televisionAdapter
        moviesList2.layoutManager= LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        moviesList2.adapter= televisionAdapter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter?.callBackData()
    }
}