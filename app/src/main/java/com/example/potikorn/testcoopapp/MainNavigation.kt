package com.example.potikorn.testcoopapp
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import com.example.potikorn.testcoopapp.adapter.AdapterPoster
import com.example.potikorn.testcoopapp.adapter.AdapterTelevision
import com.example.potikorn.testcoopapp.adapter.MyRecyclerViewAdapterButton
import com.example.potikorn.testcoopapp.contracter.MainContractor
import com.example.potikorn.testcoopapp.models.Movie
import com.example.potikorn.testcoopapp.models.Television
import com.example.potikorn.testcoopapp.models.YouVidData
import com.example.potikorn.testcoopapp.presenter.MainPresenter
import com.example.potikorn.testcoopapp.presenter.TelevisionPresenter
import kotlinx.android.synthetic.main.activity_main_navigation.*
import kotlinx.android.synthetic.main.app_bar_main_navigation.*
import kotlinx.android.synthetic.main.content_main_navigation.*

class MainNavigation: AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, MainContractor.View {
    private val movieAdapter: AdapterPoster by lazy { AdapterPoster(listOf()) }
    private val presenter: MainContractor.Presenter? by lazy { MainPresenter(this) }
    private val televisionAdapter: AdapterTelevision by lazy { AdapterTelevision(listOf()) }
    private val presenterTV: MainContractor.Presenter? by lazy { TelevisionPresenter(this) }
    private var adapterButtonRecycler: MyRecyclerViewAdapterButton? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_navigation)
        setSupportActionBar(toolbar)
        val toggle = ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        nav_view.setNavigationItemSelectedListener(this)
        presenter?.callBackData()
        presenterTV?.callBackData()
        buttonMovie()
        moviePopular()
        movieTopRated()


    }


    override fun callBackData(arr: List<Movie>?, arrTv: List<Television>?, resultsYoutube: List<YouVidData>?) {
        arr?.let { movieAdapter.setItem(it) }
        arrTv?.let { it1 -> televisionAdapter.setItem(it1) }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_Home -> {
            }
            R.id.action_Event -> {
            }
            R.id.action_About -> {
            }
            R.id.action_Newes -> {
            }
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }


    private fun buttonMovie(){
        var animalNames: ArrayList<String> = ArrayList()
        animalNames.add("Movie")
        animalNames.add("TVShows")
        animalNames.add("People")
        val horizontalLayoutManager = LinearLayoutManager(this@MainNavigation, LinearLayoutManager.HORIZONTAL, false)
        moviesButton.layoutManager = horizontalLayoutManager
        adapterButtonRecycler = MyRecyclerViewAdapterButton(this, animalNames)
        moviesButton.adapter = adapterButtonRecycler

    }

    private fun moviePopular(){
        listMovies.apply {
            layoutManager = LinearLayoutManager(this@MainNavigation, LinearLayoutManager.HORIZONTAL, false)
            adapter = movieAdapter
        }
    }
    
    private fun movieTopRated(){
        listMoviesTop.apply {
            layoutManager = LinearLayoutManager(this@MainNavigation, LinearLayoutManager.HORIZONTAL, false)
            adapter = televisionAdapter
        }

    }


}