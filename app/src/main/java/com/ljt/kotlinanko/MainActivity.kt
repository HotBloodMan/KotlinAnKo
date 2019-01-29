package com.ljt.kotlinanko

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.ljt.kotlinanko.view.MainView
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity() ,AnkoLogger{


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MainView().setContentView(this)
    }

    private fun debugLog(){
        info("hello world")
        debug("hello world")
        error("hello world")
        warn("hello world")
    }
}
