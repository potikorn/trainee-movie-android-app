package com.example.potikorn.testcoopapp

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import com.example.potikorn.testcoopapp.fragment.FragmentMovie
import kotlinx.android.synthetic.main.activity_main_fragmentation.*

class MainActivityFragmentation : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->

        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()

        when (item.itemId) {
            R.id.navigation_home -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_fragmentation)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)


        if (savedInstanceState == null) {
            // เช็ค สเตทของ แฟกเม้น ว่า มันเป็น null หรือป่าว
            supportFragmentManager.beginTransaction()
                    .add(R.id.container, FragmentMovie.newInstance("", ""), "")
                    .commit()
        }

    }
}
