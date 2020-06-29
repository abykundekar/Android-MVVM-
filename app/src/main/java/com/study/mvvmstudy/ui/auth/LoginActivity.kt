package com.study.mvvmstudy.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.study.mvvmstudy.R
import com.study.mvvmstudy.databinding.ActivityLoginBinding
import com.study.mvvmstudy.util.hide
import com.study.mvvmstudy.util.show
import com.study.mvvmstudy.util.toast
import kotlinx.android.synthetic.main.activity_signup.*

class LoginActivity : AppCompatActivity(), AuthListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Binding view model in out activity
        val binding : ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        val viewModel = ViewModelProviders.of(this).get(AuthViewModel :: class.java)
        binding.viewModel = viewModel

        //initiating the authlistener
        viewModel.authListener = this
    }

    override fun onStarted() {
        toast("Login Started")
        progress_bar.show()
    }

    override fun onSuccess(message: LiveData<String>) {
        message.observe(this, Observer {
            toast(it)
            progress_bar.hide()
        })
    }

    override fun onFailure(message: String) {
        progress_bar.hide()
        toast(message)
    }
}
