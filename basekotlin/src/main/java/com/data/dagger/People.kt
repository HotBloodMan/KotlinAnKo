package com.data.basekotlin.dagger

import javax.inject.Inject

class People @Inject constructor() {
    fun hello(){
        println("hello")
    }
}