package com.example.potikorn.testcoopapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.potikorn.testcoopapp.models.Movie
import com.example.potikorn.testcoopapp.network.BaseUrl
import kotlinx.android.synthetic.main.activity_details_movie.*

class DetailsMovie : AppCompatActivity() {
    companion object {
        const val Key = "KEY_DATA"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_movie)
        val movie: Movie = intent.getParcelableExtra(Key)
        titleMovie.text = movie.title
        sub.text = movie.overview
        Glide.with(this).load(BaseUrl.baseUrlImageMovie + movie.backdrop).into(imageMoview)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}