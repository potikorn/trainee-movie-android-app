package com.example.potikorn.testcoopapp.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.potikorn.testcoopapp.R
import com.example.potikorn.testcoopapp.contracter.TelevisionFragmentContractor
import com.example.potikorn.testcoopapp.models.television.Television
import com.example.potikorn.testcoopapp.models.television.TelevisionType
import com.example.potikorn.testcoopapp.television.adapter.AdapterTelevisionGenres
import com.example.potikorn.testcoopapp.television.adapter.AdapterTelevisionPop
import com.example.potikorn.testcoopapp.television.adapter.AdapterTelevisionTop
import com.example.potikorn.testcoopapp.television.presenter.TvFragmentPresenter
import kotlinx.android.synthetic.main.fragment_theme.*

class FragmentMovieTV : Fragment(), TelevisionFragmentContractor.View {
    private val televisionAdapterPop: AdapterTelevisionPop by lazy { AdapterTelevisionPop(listOf()) }
    private val televisionAdapterTop: AdapterTelevisionTop by lazy { AdapterTelevisionTop(listOf()) }
    private val televisionAdapterGenres: AdapterTelevisionGenres by lazy { AdapterTelevisionGenres(listOf()) }
    private val presenter: TelevisionFragmentContractor.Presenter? by lazy { TvFragmentPresenter(this) }

    override fun callbackGenres(arrTv: List<TelevisionType>?) {
        arrTv?.let { it->televisionAdapterGenres.setItem(it) }
    }

    override fun callBackPopularData(arrTv: List<Television>?) {
        arrTv?.let { it1 -> televisionAdapterPop.setItem(it1) }
    }

    override fun callTopRateData(arrTv: List<Television>?) {
        arrTv?.let { it -> televisionAdapterTop.setItem(it) }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_theme, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        televisionList?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        televisionList.adapter = televisionAdapterPop
        televisionList2.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        televisionList2.adapter = televisionAdapterTop
        genresList.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = televisionAdapterGenres
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter?.callPopularData()
        presenter?.topRateData()
        presenter?.callGenres()
    }
}