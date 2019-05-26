package com.data.basekotlin.dagger

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.data.basekotlin.R
import javax.inject.Inject

class HomeActivity : AppCompatActivity() {
    @Inject

    lateinit var  people: People

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        DaggerHomeComponent.builder()
                .build()
                .inject(this)
        people.hello()
    }
}
