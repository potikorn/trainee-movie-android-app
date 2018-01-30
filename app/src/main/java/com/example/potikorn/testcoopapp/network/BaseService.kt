package com.example.potikorn.testcoopapp.network

import com.example.potikorn.testcoopapp.models.movie.MovieList
import com.example.potikorn.testcoopapp.models.television.TelevisionList
import com.example.potikorn.testcoopapp.models.VidListFOF
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface BaseService {

    @GET("search/movie")
    fun search(@Query("query") query: String): Call<MovieList>

    @GET("movie/now_playing?language=en-US&page=1")
    fun nowPlaying(): Call<MovieList>

    @GET("search/tv?language=en-US&page=1")
    fun searchTelevision(@Query("query") query: String): Call<TelevisionList>

    @GET("tv/airing_today?language=en-US&page=1")
    fun nowTelevisionPlaying(): Call<TelevisionList>

    @GET("search?part=snippet&type=video&key=AIzaSyDYYvMZaQTgjZkAieieADreg34ElRGBvEQ")
    fun searchYoutube(@Query("q") query: String): Call<VidListFOF>
}