package com.example.potikorn.testcoopapp.network

import com.example.potikorn.testcoopapp.models.CreditList
import com.example.potikorn.testcoopapp.models.ImageList
import com.example.potikorn.testcoopapp.models.VidListFOF
import com.example.potikorn.testcoopapp.models.movie.MovieList
import com.example.potikorn.testcoopapp.models.movie.MovieTypeList
import com.example.potikorn.testcoopapp.models.movie.MovieVideoPathList
import com.example.potikorn.testcoopapp.models.television.TelevisionList
import com.example.potikorn.testcoopapp.models.television.TelevisionTypeList
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
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

    @GET("tv/on_the_air?language=en-US&page=1")
    fun televisionOnTheAir(): Call<TelevisionList>

    @GET("tv/popular?language=en-US&page=1")
    fun televisionPopular(): Observable<Response<TelevisionList>>

    @GET("tv/top_rated?language=en-US&page=1")
    fun televisionTopRate(): Observable<Response<TelevisionList>>

    @GET("discover/tv?language=en-US&sort_by=vote_average.desc&page=1&timezone=America%2FNew_York&include_null_first_air_dates=false")
    fun selectTelevisionByGenres(@Query("with_genres") query: String): Call<TelevisionTypeList>

    @GET("movie/popular?language=en-US&page=1")
    fun selectMoviePopular(): Observable<Response<MovieList>>

    @GET("movie/top_rated?&language=en-US&page=1")
    fun selectMovieTopRate(): Observable<Response<MovieList>>

    @GET("movie/upcoming?language=en-US&page=1")
    fun selectMovieUpcoming(): Call<MovieList>

    @GET("movie/{movie_id}/credits?api_key=c1618550083ac39008a92222d9c8a6a9")
    fun selectMovieCredit(@Path("movie_id") query: String): Call<CreditList>

    @GET("discover/movie?language=en-US&sort_by=vote_count.desc&include_adult=false&include_video=false&page=1")
    fun selectMovieByGenres(@Query("with_genres") query: String): Call<MovieList>

    @GET("movie/{movie_id}/images?language=en-US&include_image_language=en")
    fun selectMovieImage(@Path("movie_id") query: String): Call<ImageList>

    @GET("tv/{tv_id}/images?language=en-US")
    fun selectTelevisionImage(@Path("tv_id") query: String): Call<ImageList>

    @GET("genre/movie/list?language=en-US")
    fun selectMovieGenres(): Observable<Response<MovieTypeList>>

    @GET("genre/tv/list?language=en-US")
    fun selectTelevisionGenres(): Observable<Response<TelevisionTypeList>>

    @GET("movie/{movie_id}/videos?language=en-US")
    fun selectMovieVideoPath(@Path("movie_id") query: String): Call<MovieVideoPathList>
}