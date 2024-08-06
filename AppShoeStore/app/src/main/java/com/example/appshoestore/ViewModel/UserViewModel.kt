package com.example.appshoestore.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appshoestore.Model.User
import com.example.appshoestore.Repository.UserRepository
import com.example.appshoestore.Request.CreateAccountRequest
import com.example.appshoestore.Request.LoginAccountRequest
import com.example.appshoestore.Util.ApiResponse
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {
    private val repository: UserRepository = UserRepository()

    val createAccountResponse = MutableLiveData<ApiResponse<User>>()
    val loginAccountResponse = MutableLiveData<ApiResponse<User>>()

    // create account
    fun createAccount(request: CreateAccountRequest) {
        viewModelScope.launch {
            val response = repository.createAccount(request)
            if (response.isSuccessful) {
                createAccountResponse.postValue(response.body())
            } else {
                // Handle error
                println("Register fail")
            }
        }
    }

    // login account
    fun loginAccount(request: LoginAccountRequest) {
        viewModelScope.launch {
            val response = repository.loginAccount(request)
            if (response.isSuccessful) {
                loginAccountResponse.postValue(response.body())
            } else {
                println("Login fail")
            }
        }
    }
}