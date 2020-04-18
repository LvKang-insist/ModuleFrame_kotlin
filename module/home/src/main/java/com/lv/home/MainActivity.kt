package com.lv.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lv.modulehome.home.HomeFragment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.main_content, HomeFragment())
            .commit()
    }
}
