package com.example.potikorn.testcoopapp
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.potikorn.testcoopapp.fragment.FragmentMovie
import com.example.potikorn.testcoopapp.fragment.FragmentMovieTV
import com.example.potikorn.testcoopapp.network.BaseUrl
import kotlinx.android.synthetic.main.activity_scrolling.*
import kotlinx.android.synthetic.main.content_scrolling.*

class ScrollingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling)
        setSupportActionBar(toolbar)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.containerFragment, FragmentMovie.newInstance("", ""), "")
                    .commit() }
        setImageViewScrolling() }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                supportFragmentManager.beginTransaction()
                        .replace(R.id.containerFragment, FragmentMovie.newInstance("", ""), "")
                        .commit()
                return@OnNavigationItemSelectedListener true }
            R.id.navigation_dashboard -> {
                supportFragmentManager.beginTransaction()
                        .replace(R.id.containerFragment, FragmentMovieTV.newInstance("", ""), "")
                        .commit()
                return@OnNavigationItemSelectedListener true } }
        false }

    fun setImageViewScrolling(){ Glide.with(this).load(BaseUrl.baseUrlImageMovie+"/tcheoA2nPATCm2vvXw2hVQoaEFD.jpg").into(imageViewScrolling) }

}
