package com.study.mvvmstudy.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.study.mvvmstudy.data.repositories.UserRepository

class AuthViewModel : ViewModel() {
    var email : String? = null
    var password : String? = null

    var authListener : AuthListener? =null

    fun onLoginClicked(view : View){
        authListener?.onStarted()
        if(email.isNullOrEmpty() || password.isNullOrEmpty()){
            authListener?.onFailure("Invalid email or password")
            return
        }

        //Success
        val loginResponse = UserRepository().userLogin(email!!, password!!)
        authListener?.onSuccess(loginResponse)
    }
    
}