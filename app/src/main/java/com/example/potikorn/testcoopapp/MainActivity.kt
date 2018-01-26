package com.example.potikorn.testcoopapp
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.potikorn.testcoopapp.models.MovieList

class MainActivity : AppCompatActivity(), MainContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val presenter = MainPresenter(this)
        presenter.requestNowPlaying()
    }

    override fun onNowMovieDataSuccess(results: MovieList) {
        Log.e("now playing movie", results.toString())
    }
}
