package com.example.marsphotos

import android.app.Application
import com.example.marsphotos.data.AppContainer
import com.example.marsphotos.data.DefaultAppContainer

class MarsPhotosApplication : Application() {
    lateinit var container: AppContainer//this is lateinit because variable is initialized during call to onCreate() so there is no delay
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }

}