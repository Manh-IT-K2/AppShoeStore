package com.example.appshoestore.Util

data class ApiResponse<T>(
    val status: Boolean,
    private val message: String,
    private val data: T
)