package com.lv.modulehome.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.lv.modulehome.R
import com.xiaojinzi.component.anno.FragmentAnno

@FragmentAnno("HomeFragment")
class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return LayoutInflater.from(context).inflate(R.layout.frag_home, container, false)
    }
}