package com.example.potikorn.testcoopapp.genres

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.potikorn.testcoopapp.R
import com.example.potikorn.testcoopapp.genres.adapter.AdapterGenres
import kotlinx.android.synthetic.main.activity_genres_theme.*

class GenresTheme : AppCompatActivity() {
    private val movieAdapter: AdapterGenres by lazy { AdapterGenres(listOf()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(R.layout.activity_genres_theme)
        listGenresMovie.layoutManager = LinearLayoutManager(this)


    }


}
