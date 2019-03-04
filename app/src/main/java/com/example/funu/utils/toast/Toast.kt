package com.example.funu.utils.toast

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import com.example.funu.ui.fragment.ProgressFragment

fun Activity.toast(msg:String) {
    Toast.makeText(applicationContext,msg,Toast.LENGTH_SHORT).show()
}

fun Activity.toast(msgId:Int) {
    Toast.makeText(applicationContext,msgId,Toast.LENGTH_SHORT).show()
}

fun AppCompatActivity.showProgress() {
    val dialog = ProgressFragment.newInstance()
    dialog.show(supportFragmentManager, ProgressFragment::class.java.simpleName)
}

fun AppCompatActivity.dismissProgress() {
    (supportFragmentManager.findFragmentByTag(ProgressFragment::class.java.simpleName) as ProgressFragment?)?.dismiss()

}

fun String.isEmpty(str:String):Boolean {
    return str == null || str == ""
}
