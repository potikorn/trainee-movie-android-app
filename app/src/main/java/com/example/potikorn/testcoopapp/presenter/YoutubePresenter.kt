package com.example.potikorn.testcoopapp.presenter
import com.example.potikorn.testcoopapp.InterActor
import com.example.potikorn.testcoopapp.contracter.MainContractor
import com.example.potikorn.testcoopapp.models.InterArty
import com.example.potikorn.testcoopapp.models.VidListFOF

class YoutubePresenter(val view: MainContractor.View? = null) : MainContractor.Presenter, InterActor.OnFinishedListenerMovie {
    override fun <T> onSuccessTop(t: T) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <T> onSuccessPop(t: T) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <T> onSuccessGenres(t: T) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

//    override fun onSuccessTop(results: List<Movie>?, resultTv: List<Television>?, resultsYoutube: List<YouVidData>?) {
//        view?.callBackPopularData(results, resultTv , resultsYoutube)
//    }

    private val act: InterActor.ActData by lazy { InterArty() }

    override fun callBackData(key: String?) {}
//    act.callYoutubeData(key.toString(),this)
}