package com.data.basekotlin.dagger

import dagger.Component

@Component
interface HomeComponent {
    fun inject(activity:HomeActivity)
}