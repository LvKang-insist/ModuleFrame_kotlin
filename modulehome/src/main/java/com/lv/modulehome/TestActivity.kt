package com.lv.modulehome

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import com.xiaojinzi.component.anno.RouterAnno

@RouterAnno(host = "moduleHome", path = "test")
class TestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tv = AppCompatTextView(this)
        tv.text = "345"
        setContentView(tv)
        tv.setOnClickListener {

        }
    }
}