package com.junjc9.funu.ui.activity.license

class LicensePresenter(view: LicenseContract.View) : LicenseContract.Presenter {

    private val mView = view

    init {
        mView.setPresenter(this)
    }

    override fun subscribe() {

    }

    override fun unsubscribe() {

    }

}