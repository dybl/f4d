package com.junjc9.funu.ui.activity.license

import com.junjc9.funu.mvp.BasePresenter
import com.junjc9.funu.mvp.BaseView

interface LicenseContract {

    interface View : BaseView<Presenter>

    interface Presenter : BasePresenter

}