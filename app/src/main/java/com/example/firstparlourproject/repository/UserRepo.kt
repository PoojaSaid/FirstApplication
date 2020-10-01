package com.example.firstparlourproject.repository

import androidx.lifecycle.LiveData
import androidx.room.Dao
import com.example.firstparlourproject.data.UserDao
import com.example.firstparlourproject.model.user

@Dao
class UserRepo(private val userDao: UserDao) {

//    private val userList:List<user>()
    val readAllData: LiveData<List<user>> = userDao.readAllData()

    suspend fun registerUser(User: user) {
        userDao.addUser(User)
    }

    suspend fun customerData(userEmailId:String, userPassword:String){
        userDao.readUser(userEmailId,userPassword)
    }

}