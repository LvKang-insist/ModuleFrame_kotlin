package com.lv.frame

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.xiaojinzi.component.impl.Router
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv.setOnClickListener {
            val fragment = Router.with("HomeFragment").navigate()
            if (fragment != null){
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_content, fragment)
                    .commit()
            }
        }
    }
}
