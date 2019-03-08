package com.junjc9.funu.ui.activity

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.junjc9.funu.R
import com.junjc9.funu.ui.activity.about.AboutActivity
import com.junjc9.funu.ui.activity.license.LicensesActivity
import com.junjc9.funu.ui.activity.setting.SettingsActivity
import com.junjc9.funu.ui.fragment.WelfareFragment
import kotlinx.android.synthetic.main.activity_draw.*
import kotlinx.android.synthetic.main.app_bar_draw.*
import kotlinx.android.synthetic.main.content_draw.*

class DrawActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private var lastIndex = -1
    private var lastFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_draw)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

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

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.draw, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            R.id.action_open_in_browser -> return true;
            R.id.action_help_and_feedback -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }



    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                // Handle the camera action
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {
                startActivity(Intent(this,LicensesActivity::class.java))

            }
            R.id.nav_about -> {
                startActivity(Intent(this,AboutActivity::class.java))
            }
            R.id.nav_setting -> {
                startActivity(Intent(this,SettingsActivity::class.java))

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
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

