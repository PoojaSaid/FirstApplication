package com.example.firstparlourproject.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.firstparlourproject.data.parlourDatabse
import com.example.firstparlourproject.model.user
import com.example.firstparlourproject.repository.UserRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: UserRepo
    val readAllData: LiveData<List<user>>

    init {
        val userDao = parlourDatabse.getDatabase(application).userDao()
        repository = UserRepo(userDao)
        readAllData = repository.readAllData

    }


    fun addUser(User: user){
        viewModelScope.launch(Dispatchers.IO) {
            repository.registerUser(User)
        }
    }


    fun getCustomerDetails(userEmail:String, userPassword:String){
        viewModelScope.launch ( Dispatchers.IO ){
            repository.customerData(userEmail,userPassword)
        }
    }

}