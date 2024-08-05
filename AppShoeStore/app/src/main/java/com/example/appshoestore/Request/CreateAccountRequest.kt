package com.example.appshoestore.Request

data class CreateAccountRequest(
    val userName: String,
    val passWord: String,
    val email: String
)