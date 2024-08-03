package com.example.appshoestore.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appshoestore.Model.User
import com.example.appshoestore.Repository.UserRepository
import com.example.appshoestore.Util.ApiResponse

class UserViewModel(private val repository: UserRepository) : ViewModel() {

    val createAccountResponse = MutableLiveData<ApiResponse<User>>()
    val loginAccountResponse = MutableLiveData<ApiResponse<User>>()


}