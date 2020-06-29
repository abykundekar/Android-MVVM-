package com.study.mvvmstudy.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.study.mvvmstudy.data.entities.User

@Database(
    entities = [User :: class]
    , version = 1
)
abstract class AppDatabase : RoomDatabase(){

}