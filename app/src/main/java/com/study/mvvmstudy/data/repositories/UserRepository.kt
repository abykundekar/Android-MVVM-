package com.study.mvvmstudy.data.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.study.mvvmstudy.data.network.MyApi
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {

    val TAG = "UserRepo"
    fun userLogin(email : String, password : String) : LiveData<String>{
        var loginResponse = MutableLiveData<String>()

        MyApi().userLogin(email, password)
            .enqueue(object : Callback<ResponseBody>{
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    loginResponse.value = t.message
                }

                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                    if (response.isSuccessful){
                        loginResponse.value = response.body()?.string()
                        Log.d(TAG, "response is "+loginResponse.value)
                    }else{
                        loginResponse.value = response.errorBody()?.string()
                        Log.d(TAG, "response is "+loginResponse.value)
                    }
                }
            })
       return loginResponse
    }
}