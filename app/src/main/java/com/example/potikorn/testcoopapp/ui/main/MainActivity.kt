package com.example.potikorn.testcoopapp.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.potikorn.testcoopapp.R
import com.example.potikorn.testcoopapp.ui.main.home.HomeFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
                .replace(R.id.containerFragment, HomeFragment.newInstance(), HomeFragment::class.java.simpleName)
                .commitAllowingStateLoss()
    }

}