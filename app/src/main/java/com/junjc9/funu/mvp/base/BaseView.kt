package com.junjc9.funu.mvp


interface BaseView<in T> {

    fun setPresenter(presenter : T)

}