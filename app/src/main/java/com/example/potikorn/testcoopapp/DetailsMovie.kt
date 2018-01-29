package com.example.potikorn.testcoopapp
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.potikorn.testcoopapp.network.BaseUrl
import kotlinx.android.synthetic.main.activity_details_movie.*

class DetailsMovie : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_movie)
        var subtitle = intent.extras?.getString("KEY_DATA")
        var image = intent.extras?.getString("KEY_IMAGE")
        sub.setText(subtitle)
        Glide.with(this).load(BaseUrl.baseUrlImageMovie+image).into(imageMoview)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}
