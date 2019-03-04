package com.example.funu.ui.activity

import android.os.Bundle
//import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import com.example.funu.R
import com.example.funu.ui.fragment.WelfareFragment
import kotlinx.android.synthetic.main.activity_main.*

/*
class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.bbn_recommend -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.bbn_girl -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.bbn_history -> {
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
*/

class MainActivity : AppCompatActivity() {

    private var lastIndex = -1
    private var lastFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {

                R.id.bbn_girl -> {
                    changeTab(0)
                }

                R.id.bbn_recommend -> {
                    changeTab(1)
                }

                R.id.bbn_history -> {
                    changeTab(2)
                }
            }

            true
        }

        //set default fragment
        changeTab(0)

    }

    fun changeTab(position: Int) {

        if (lastIndex == position) {
            return
        }

        lastIndex = position

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        lastFragment?.let {
            fragmentTransaction.hide(it)
        }

        when (position) {
            0 -> {
                var girlFragment = fragmentManager.findFragmentByTag(
                    WelfareFragment::class.java.simpleName) as WelfareFragment?

                if (girlFragment == null) {
                    girlFragment = WelfareFragment.newInstance()
                    fragmentTransaction.add(R.id.container, girlFragment,
                        WelfareFragment::class.java.simpleName)
                } else {
                    fragmentTransaction.show(girlFragment)
                }

                lastFragment = girlFragment
            }

        }

        fragmentTransaction.commit()
    }
}

