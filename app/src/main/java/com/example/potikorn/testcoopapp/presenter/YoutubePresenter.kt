package com.example.potikorn.testcoopapp.presenter
import com.example.potikorn.testcoopapp.InterActor
import com.example.potikorn.testcoopapp.contracter.MainContractor
import com.example.potikorn.testcoopapp.models.InterArty
import com.example.potikorn.testcoopapp.models.VidListFOF
import com.example.potikorn.testcoopapp.models.movie.Movie
import com.example.potikorn.testcoopapp.models.television.Television
import com.example.potikorn.testcoopapp.models.YouVidData

class YoutubePresenter(val view: MainContractor.View? = null) : MainContractor.Presenter, InterActor.OnFinishedListener {
    override fun <T> onSuccess(t: T) {
        view?.callBackData(resultsYoutube = (t as VidListFOF).results)
    }
//    override fun onSuccessTop(results: List<Movie>?, resultTv: List<Television>?, resultsYoutube: List<YouVidData>?) {
//        view?.callBackPopularData(results, resultTv , resultsYoutube)
//    }

    private val act: InterActor.ActData by lazy { InterArty() }

    override fun callBackData(key: String?) {}
//    act.callYoutubeData(key.toString(),this)
}