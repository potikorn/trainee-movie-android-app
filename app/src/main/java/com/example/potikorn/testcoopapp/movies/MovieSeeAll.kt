package com.example.potikorn.testcoopapp.movies
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.potikorn.testcoopapp.R
import com.example.potikorn.testcoopapp.contracter.MovieFragmentContractor
import com.example.potikorn.testcoopapp.models.movie.Movie
import com.example.potikorn.testcoopapp.models.movie.MovieType
import com.example.potikorn.testcoopapp.movies.adapter.AdapterDetails
import com.example.potikorn.testcoopapp.movies.presenter.MovieFragmentPresenter
import kotlinx.android.synthetic.main.fragment_theme.*

class MovieSeeAll : AppCompatActivity(), MovieFragmentContractor.View {
    private val movieAdapterSeeAll: AdapterDetails by lazy { AdapterDetails(listOf()) }
    private var presenter: MovieFragmentContractor.Presenter? = MovieFragmentPresenter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(R.layout.activity_details_type_movie)
        televisionList?.layoutManager = LinearLayoutManager(this)
        televisionList.adapter = movieAdapterSeeAll



        var type = intent.extras.getInt("KEY_DATA_MOVIE")
        if(type==1){
            presenter?.callPopularData()
        }else{ presenter?.topRateData() } }

    override fun callbackGenres(arrMovie: List<MovieType>?) {}

    override fun callBackPopularData(arrMovie: List<Movie>?) {
        arrMovie?.let { it->movieAdapterSeeAll.setItem(it) } }

    override fun callTopRateData(arrMovie: List<Movie>?) {
        arrMovie?.let { it->movieAdapterSeeAll.setItem(it) } }


}