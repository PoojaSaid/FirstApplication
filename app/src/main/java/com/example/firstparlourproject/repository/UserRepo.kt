package com.example.firstparlourproject.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import com.example.firstparlourproject.data.UserDao
import com.example.firstparlourproject.model.user

@Dao
class UserRepo(private val userDao: UserDao) {

    val readAllData: LiveData<List<user>> = userDao.readAllData()

     fun readCustObj(userEmail:String, userPassword:String): LiveData<List<user>>?{
        val customer = userDao.readUser(userEmail,userPassword)
         Log.d("Cust", customer?.value.toString())
        return customer
    }

    suspend fun registerUser(User: user) {
        userDao.addUser(User)
    }



}