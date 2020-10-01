package com.example.firstparlourproject.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.firstparlourproject.model.user


@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: user)

    @Query("SELECT * FROM user WHERE u_email IN (:userEmailId) AND u_password IN (:userPassword)")
    fun readUser(userEmailId:String, userPassword:String): LiveData<user>

    @Query("SELECT * FROM user ORDER BY u_id ASC")
    fun readAllData():LiveData<List<user>>

}