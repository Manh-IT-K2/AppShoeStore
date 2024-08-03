package com.example.appshoestore.Request

data class CreateAccountRequest(
    val username: String,
    val password: String,
    val email: String
)