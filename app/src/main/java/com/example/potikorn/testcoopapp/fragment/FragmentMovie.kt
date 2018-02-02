package com.example.potikorn.testcoopapp.fragment
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.potikorn.testcoopapp.R
import com.example.potikorn.testcoopapp.movies.adapter.AdapterMovieGenres
import com.example.potikorn.testcoopapp.movies.adapter.AdapterPoster
import com.example.potikorn.testcoopapp.contracter.MovieFragmentContractor
import com.example.potikorn.testcoopapp.models.movie.Movie
import com.example.potikorn.testcoopapp.models.movie.MovieType
import com.example.potikorn.testcoopapp.movies.MovieSeeAll
import com.example.potikorn.testcoopapp.movies.presenter.MovieFragmentPresenter
import kotlinx.android.synthetic.main.fragment_theme.*


class FragmentMovie : Fragment(),MovieFragmentContractor.View{

    private val movieAdapterPop: AdapterPoster by lazy { AdapterPoster(listOf()) }
    private val movieAdapterTop: AdapterPoster by lazy { AdapterPoster(listOf()) }
    private var presenter: MovieFragmentContractor.Presenter? = MovieFragmentPresenter(this)
    private  val movieAdapterGenres: AdapterMovieGenres by lazy { AdapterMovieGenres(listOf()) }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
            inflater!!.inflate(R.layout.fragment_theme, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        televisionList?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        televisionList.adapter = movieAdapterPop
        televisionList2.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        televisionList2.adapter = movieAdapterTop
        genresList.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = movieAdapterGenres
        }

        seeAllPopular.setOnClickListener {
            val intent = Intent(context, MovieSeeAll::class.java)
            intent.putExtra("KEY_DATA_MOVIE", 1)
            this.startActivity(intent)
        }
        seeAllTop.setOnClickListener {
            val intent = Intent(context, MovieSeeAll::class.java)
            intent.putExtra("KEY_DATA_MOVIE", 2)
            this.startActivity(intent)
        }



    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter?.topRateData()
        presenter?.callPopularData()
        presenter?.callGenres()
    }


    override fun callbackGenres(arrMovie: List<MovieType>?) {
        arrMovie?.let { it->movieAdapterGenres.setItem(it) }
    }

    override fun callBackPopularData(arrMovie: List<Movie>?) {

        arrMovie?.let { it->movieAdapterPop.setItem(it) }
    }

    override fun callTopRateData(arrMovie: List<Movie>?) {
        arrMovie?.let {it-> movieAdapterTop.setItem(it) }
    }





}