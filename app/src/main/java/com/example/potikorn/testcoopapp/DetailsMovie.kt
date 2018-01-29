package com.example.potikorn.testcoopapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.bumptech.glide.Glide
import com.example.potikorn.testcoopapp.models.Movie
import com.example.potikorn.testcoopapp.network.BaseUrl
import kotlinx.android.synthetic.main.activity_details_movie.*

class DetailsMovie : AppCompatActivity() {
    companion object {
        val Key = "KEY_DATA"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_movie)
        val movie: Movie = intent.getParcelableExtra(Key)
        sub.text = movie.title
        Glide.with(this).load(BaseUrl.baseUrlImageMovie + movie.backdrop).into(imageMoview)
        Log.e("check data ", movie.toString())
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}
