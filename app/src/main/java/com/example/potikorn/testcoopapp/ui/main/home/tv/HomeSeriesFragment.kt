package com.example.potikorn.testcoopapp.ui.main.home.tv

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.potikorn.testcoopapp.R
import com.example.potikorn.testcoopapp.load
import com.example.potikorn.testcoopapp.models.television.Television
import com.example.potikorn.testcoopapp.models.television.TelevisionList
import com.example.potikorn.testcoopapp.network.BaseUrl
import kotlinx.android.synthetic.main.fragmen_home_detail.*
import kotlinx.android.synthetic.main.list_item_movie.view.*
import kotlin.properties.Delegates

class HomeSeriesFragment: Fragment(), HomeSeriesFragmentContract.View {

    val onAirAdapter: InTheaterAdapter by lazy { InTheaterAdapter() }
    val presenter: HomeSeriesFragmentPresenter by lazy { HomeSeriesFragmentPresenter(this) }

    companion object {
        fun newInstance(bundle: Bundle? = null) = HomeSeriesFragment().apply {
            val homeSeriesFragment = HomeSeriesFragment()
            homeSeriesFragment.arguments = bundle
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragmen_home_detail, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvInTheater.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = onAirAdapter
        }
        presenter.apply {
            progressBar.visibility = View.VISIBLE
            requestNowOnAir()
        }
    }

    override fun getOnAirSeriesData(dataList: TelevisionList) {
        progressBar.visibility = View.GONE
        onAirAdapter.items = dataList.results?.toMutableList() ?: mutableListOf()
    }

    inner class InTheaterAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

        var items: MutableList<Television> by Delegates.observable(mutableListOf(), { _, _, _ -> notifyDataSetChanged() })

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
            val view = LayoutInflater.from(context).inflate(R.layout.list_item_movie, parent, false)
            return InTheaterViewHolder(view)
        }

        override fun getItemCount(): Int = items.size

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
            return (holder as InTheaterViewHolder).onBind(items[position])
        }

        inner class InTheaterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            fun onBind(item: Television) {
                itemView.imagePoster.load("${BaseUrl.baseUrlImageMovie}${item.poster_path}")
            }
        }
    }
}