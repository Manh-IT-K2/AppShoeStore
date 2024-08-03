package com.example.appshoestore.Service

import com.example.appshoestore.Model.Products
import com.example.appshoestore.Model.User
import com.example.appshoestore.Request.CreateAccountRequest
import com.example.appshoestore.Request.LoginAccountRequest
import com.example.appshoestore.Util.ApiResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UserService {

    // create account
    @POST("user/createAccount")
    suspend fun createAccount(@Body request: CreateAccountRequest): Response<ApiResponse<User>>

    // login account
    @POST("user/loginAccount")
    suspend fun loginAccount(@Body request: LoginAccountRequest): Response<ApiResponse<User>>
}
