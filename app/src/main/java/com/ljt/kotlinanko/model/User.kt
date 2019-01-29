package com.ljt.kotlinanko.model

data class User(val x:Int,val y:Int) {
    override fun toString(): String {
        return "x="+x +"  y="+y
    }
}