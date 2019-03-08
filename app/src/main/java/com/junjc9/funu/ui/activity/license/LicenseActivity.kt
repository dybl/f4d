package com.junjc9.funu.ui.activity.license

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.junjc9.funu.R
import com.junjc9.funu.ui.fragment.LicensesFragment
import kotlinx.android.synthetic.main.common_toolbar.*


class LicensesActivity : AppCompatActivity() {

    private lateinit var mLicensesFragment: LicensesFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_common)

        setSupportActionBar(toolbar)
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setDisplayShowHomeEnabled(true)
            it.setTitle(R.string.open_source_licenses)
        }

        savedInstanceState?.let {
            mLicensesFragment = supportFragmentManager.getFragment(it, LicensesFragment::class.java.simpleName) as LicensesFragment
        } ?: run {
            mLicensesFragment = LicensesFragment.newInstance()
        }

        if (!mLicensesFragment.isAdded) {
            supportFragmentManager.beginTransaction()
                .add(R.id.container, mLicensesFragment, LicensesFragment::class.java.simpleName)
                .commit()
        }

        LicensePresenter(mLicensesFragment)

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if (mLicensesFragment.isAdded) {
            supportFragmentManager.putFragment(outState, LicensesFragment::class.java.simpleName, mLicensesFragment)
        }
    }

}