package com.example.firstparlourproject.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.firstparlourproject.model.user


@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: user)

    @Query("SELECT * FROM user WHERE u_email = :userEmailId AND u_password = :userPassword")
    fun readUser(userEmailId:String, userPassword:String): LiveData<List<user>>?

    @Query("SELECT * FROM user")
    fun readAllData():LiveData<List<user>>


}