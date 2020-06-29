package com.study.mvvmstudy.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.study.mvvmstudy.data.entities.CURRENT_USER_ID
import com.study.mvvmstudy.data.entities.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(user : User) : Long

    @Query("SELECT * FROM user where uid = $CURRENT_USER_ID")
    fun getUser() : LiveData<User>
}