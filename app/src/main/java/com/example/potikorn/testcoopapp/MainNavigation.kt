package com.example.potikorn.testcoopapp
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.design.widget.Snackbar
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.example.potikorn.testcoopapp.movies.adapter.MyRecyclerViewAdapterButton
import com.example.potikorn.testcoopapp.fragment.FragmentMovie
import com.example.potikorn.testcoopapp.fragment.FragmentMovieTV
import com.example.potikorn.testcoopapp.network.BaseUrl
import com.github.ivbaranov.mfb.MaterialFavoriteButton
import kotlinx.android.synthetic.main.activity_main_navigation.*
import kotlinx.android.synthetic.main.app_bar_main_navigation.*
import kotlinx.android.synthetic.main.content_main_navigation.*

class MainNavigation: AppCompatActivity(),
        MyRecyclerViewAdapterButton.ItemClickListener {
    private var adapterButtonRecycler: MyRecyclerViewAdapterButton? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_navigation)
        setSupportActionBar(toolbar)
        buttonMovie()
        image.load(BaseUrl.baseUrlImageMovie + getString(R.string.movie_tail_path))
        adapterButtonRecycler?.setClickListener(this)
        if (savedInstanceState != null) return
        supportFragmentManager.beginTransaction()
                .replace(R.id.containerFragment, FragmentMovie(), "")
                .commit()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu) }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.search) {
            startActivity(Intent(this , SearchActivity::class.java))
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left) }
        return super.onOptionsItemSelected(item) }

    companion object {
        const val YOU_HEAD_PATH ="https://i.ytimg.com/vi/"
        const val YOU_TAIL = "/mqdefault.jpg"
    }




    private fun buttonMovie(){
        var animalNames: ArrayList<String> = ArrayList()
        animalNames.add("Movie")
        animalNames.add("TVShows")
        animalNames.add("People")
        val horizontalLayoutManager = LinearLayoutManager(this@MainNavigation, LinearLayoutManager.HORIZONTAL, false)
        moviesButton.layoutManager = horizontalLayoutManager
        adapterButtonRecycler = MyRecyclerViewAdapterButton(this, animalNames)
        moviesButton.adapter = adapterButtonRecycler }

    override fun onItemClick(view: View, position: Int) {
        when (position) {
            0 -> {supportFragmentManager.beginTransaction()
                    .replace(R.id.containerFragment, FragmentMovie(), "")
                    .commit()
            }
            1 -> {supportFragmentManager.beginTransaction()
                    .replace(R.id.containerFragment, FragmentMovieTV(), "")
                    .commit() }
            2 -> {supportFragmentManager.beginTransaction()
                    .replace(R.id.containerFragment, FragmentMovie(), "")
                    .commit() } }
    } }

