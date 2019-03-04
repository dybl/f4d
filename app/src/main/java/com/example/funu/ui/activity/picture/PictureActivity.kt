package com.example.funu.ui.activity.picture

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.text.TextUtils
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.example.funu.R
import kotlinx.android.synthetic.main.activity_picture.*
import kotlinx.android.synthetic.main.common_toolbar.*


class PictureActivity :AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picture)

        initToolbar()

        val url = intent.getStringExtra("url")
        if (TextUtils.isEmpty(url)) {
            finish()
            return
        }

        Glide
            .with(this)
            .load(url)

            .into(photoView)
    }

    private fun initToolbar() {
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar!!.title = ""
        actionBar.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }

    }
}