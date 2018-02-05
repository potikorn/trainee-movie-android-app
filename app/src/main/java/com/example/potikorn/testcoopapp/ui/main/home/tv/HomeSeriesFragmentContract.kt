package com.example.potikorn.testcoopapp.ui.main.home.tv

import com.example.potikorn.testcoopapp.models.television.TelevisionList

interface HomeSeriesFragmentContract {

    interface View {
        fun getOnAirSeriesData(dataList: TelevisionList)
    }

    interface Presenter {
        fun requestNowOnAir()
    }

}
