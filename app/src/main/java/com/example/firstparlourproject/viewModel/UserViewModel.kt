package com.example.firstparlourproject.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.firstparlourproject.data.parlourDatabse
import com.example.firstparlourproject.model.user
import com.example.firstparlourproject.repository.UserRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

 class UserViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: UserRepo
    val readAllData: LiveData<List<user>>
//    private val readCust: LiveData<List<user>>?
//    val userObj: LiveData<user> = null

    init {
        val userDao = parlourDatabse.getDatabase(application).userDao()
        repository = UserRepo(userDao)
        readAllData = repository.readAllData

    }


    fun addUser(User: user) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.registerUser(User)
        }
    }


   fun getCustomerDetails(userEmail: String, userPassword: String):LiveData<List<user>>? {

     var demo : LiveData<List<user>>? = null
        viewModelScope.launch(Dispatchers.IO) {
             demo= repository.readCustObj(userEmail, userPassword)
//            demo.value
            Log.d("checking",demo?.value.toString())

        }
    return  demo
    }
}