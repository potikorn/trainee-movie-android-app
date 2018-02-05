package com.example.potikorn.testcoopapp.television

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.potikorn.testcoopapp.R
import com.example.potikorn.testcoopapp.contactor.TelevisionFragmentContractor
import com.example.potikorn.testcoopapp.models.CreditActor
import com.example.potikorn.testcoopapp.models.Crew
import com.example.potikorn.testcoopapp.models.television.Television
import com.example.potikorn.testcoopapp.models.television.TelevisionType
import com.example.potikorn.testcoopapp.television.adapter.AdapterDetailsTv
import com.example.potikorn.testcoopapp.television.presenter.TvFragmentPresenter
import kotlinx.android.synthetic.main.activity_details_type_movie.*


class TvSeeAll : AppCompatActivity(), TelevisionFragmentContractor.View {
    override fun callCredit(arrActor: List<CreditActor>?) {

    }

    override fun callCrew(arrActor: List<Crew>?) {
    }

    private val movieAdapterSeeAll: AdapterDetailsTv by lazy { AdapterDetailsTv(listOf()) }
    private val presenter: TelevisionFragmentContractor.Presenter by lazy { TvFragmentPresenter(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(R.layout.activity_details_type_movie)
        televisionList?.layoutManager = LinearLayoutManager(this)
        televisionList.adapter = movieAdapterSeeAll
        var type = intent.extras.getInt("KEY_DATA_TV")
        if (type == 1) {
            presenter?.callPopularData()
        } else {
            presenter?.topRateData()
        }


    }

    override fun callbackGenres(arrTv: List<TelevisionType>?) {
    }

    override fun callBackPopularData(arrTv: List<Television>?) {
        arrTv?.let { it -> movieAdapterSeeAll.setItem(it) }
    }

    override fun callTopRateData(arrTv: List<Television>?) {
        arrTv?.let { it -> movieAdapterSeeAll.setItem(it) }
    }


}