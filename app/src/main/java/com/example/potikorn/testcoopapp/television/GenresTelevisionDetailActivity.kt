package com.example.potikorn.testcoopapp.television

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.potikorn.testcoopapp.R
import com.example.potikorn.testcoopapp.contactor.TelevisionFragmentContractor
import com.example.potikorn.testcoopapp.models.CreditActor
import com.example.potikorn.testcoopapp.models.Crew
import com.example.potikorn.testcoopapp.models.television.Television
import com.example.potikorn.testcoopapp.models.television.TelevisionType
import com.example.potikorn.testcoopapp.television.adapter.AdapterTelevisionDetailGenres
import com.example.potikorn.testcoopapp.television.holder.TelevisionViewHolderGenres
import com.example.potikorn.testcoopapp.television.presenter.TvGenresShowDetailPresenter
import kotlinx.android.synthetic.main.activity_genres_television_detail.*

@SuppressLint("Registered")
class GenresTelevisionDetailActivity : AppCompatActivity(), TelevisionFragmentContractor.View {
    override fun callCredit(arrActor: List<CreditActor>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun callCrew(arrActor: List<Crew>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private val myAdapter: AdapterTelevisionDetailGenres by lazy { AdapterTelevisionDetailGenres(listOf()) }
    private val presenter: TelevisionFragmentContractor.Presenter? by lazy { TvGenresShowDetailPresenter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_genres_television_detail)
        val keyword = intent.getStringExtra(TelevisionViewHolderGenres.KEY_GENRES)
        presenter?.topRateData(keyword)
        tvGenresDetailList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = myAdapter
        }
    }

    override fun callbackGenres(arrTv: List<TelevisionType>?) {
    }

    override fun callBackPopularData(arrTv: List<Television>?) {
    }

    override fun callTopRateData(arrTv: List<Television>?) {
        arrTv?.let { it -> myAdapter.setItem(it) }
    }
}
