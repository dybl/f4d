package com.junjc9.funu.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import java.util.*


class BaseAdapter(var data:List<Fragment> = ArrayList(), var titles :Array<String>,fm:FragmentManager) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return data[position]
    }

    override fun getCount(): Int {
        return data.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return titles[position]
    }
}