package com.example.funu.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.funu.R

class BaseFragment : Fragment(){

    var rootView:View? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (rootView == null)
        {
            rootView = inflater!!.inflate(R.layout.fragment_base,container,false)
        }
        return rootView
    }
}