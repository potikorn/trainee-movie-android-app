package com.example.potikorn.testcoopapp.network

import com.example.potikorn.testcoopapp.models.MovieList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface BaseService {

    @GET("search/movie")
    fun search(@Query("query") query: String): Call<MovieList>

    @GET("movie/now_playing?api_key=c1618550083ac39008a92222d9c8a6a9&language=en-US&page=1")
    fun nowPlaying(): Call<MovieList>

}