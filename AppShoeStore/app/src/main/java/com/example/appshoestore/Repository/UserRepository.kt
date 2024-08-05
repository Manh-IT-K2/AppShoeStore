package com.example.appshoestore.Repository

import com.example.appshoestore.Request.CreateAccountRequest
import com.example.appshoestore.Request.LoginAccountRequest
import com.example.appshoestore.Service.UserService
import com.example.appshoestore.Util.RetrofitInstance

class UserRepository() {

    private val api: UserService = RetrofitInstance.api
    // create account
    suspend fun createAccount(request: CreateAccountRequest) = api.createAccount(request)

    // login account
    suspend fun loginAccount(request: LoginAccountRequest) = api.loginAccount(request)
}