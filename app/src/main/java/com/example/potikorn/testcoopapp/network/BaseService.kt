package com.example.fluke.fuckermovie2.network

import com.example.potikorn.testcoopapp.models.MovieList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface BaseService {

@GET("search/movie")
fun search(@Query("query") query: String): Call<MovieList>

@GET("discover/movie?sort_by=popularity.desc")
fun popular(): Call<MovieList>

}