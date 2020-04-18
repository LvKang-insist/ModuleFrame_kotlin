package com.lv.home.application

import android.app.Application
import android.util.Log

class HomeApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Log.e("HomeApplication", "init")
    }
}