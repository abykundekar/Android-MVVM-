package com.study.mvvmstudy.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

const val CURRENT_USER_ID = 0

@Entity
data class User (
    var id : Int? = null,
    var name : String? = null,
    var email : String? = null,
    var password : String? = null,
    var email_verified_at : String? = null,
    var created_at : String? = null,
    var updated_at : String? = null
){
    //to allow only single user user to use the application
    @PrimaryKey(autoGenerate = false)
    var uid : Int? = CURRENT_USER_ID
}
