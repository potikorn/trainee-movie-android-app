package com.example.potikorn.testcoopapp.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.potikorn.testcoopapp.R
import com.example.potikorn.testcoopapp.adapter.AdapterPoster
import com.example.potikorn.testcoopapp.contracter.MainContractor
import com.example.potikorn.testcoopapp.models.YouVidData
import com.example.potikorn.testcoopapp.models.movie.Movie
import com.example.potikorn.testcoopapp.models.television.Television
import com.example.potikorn.testcoopapp.presenter.MainPresenter
import kotlinx.android.synthetic.main.fragment_theme.*

class FragmentMovie : Fragment(), MainContractor.View {

    private val movieAdapter: AdapterPoster by lazy { AdapterPoster(listOf()) }
    private var presenter: MainContractor.Presenter? = MainPresenter(this)
    override fun callBackData(arr: List<Movie>?, arrTv: List<Television>?, resultsYoutube: List<YouVidData>?) {
        arr?.let { movieAdapter.setItem(it) }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
            inflater!!.inflate(R.layout.fragment_theme, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        televisionList?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        televisionList.adapter = movieAdapter
        televisionList2.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        televisionList2.adapter = movieAdapter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter?.callBackData()
    }

}