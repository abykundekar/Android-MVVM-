package com.study.mvvmstudy.util

import android.content.Context
import android.widget.ProgressBar
import android.widget.Toast

fun Context.toast(message : String){
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun ProgressBar.show(){
    visibility = ProgressBar.VISIBLE
}

fun ProgressBar.hide(){
    visibility = ProgressBar.GONE
}