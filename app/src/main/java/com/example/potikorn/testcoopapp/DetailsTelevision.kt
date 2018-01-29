package com.example.potikorn.testcoopapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.potikorn.testcoopapp.models.Television
import com.example.potikorn.testcoopapp.network.BaseUrl
import kotlinx.android.synthetic.main.activity_details_movie.*

@SuppressLint("Registered")
class DetailsTelevision : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_movie)

        val television: Television = intent.getParcelableExtra(DetailsMovie.Key)
        titleMovie.text = television.name
        sub.text = television.overview
        Glide.with(this).load(BaseUrl.baseUrlImageMovie + television.backdrop_path).into(imageMoview)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}