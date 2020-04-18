package com.lv.frame.application

import android.app.Application
import com.lv.core.config.Config

class GlobalApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Config.build()
            .withApplication(this)
            .withComponent()
            .configure()
    }
}