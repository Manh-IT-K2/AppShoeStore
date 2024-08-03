package com.example.appshoestore.Util

data class ApiResponse<T>(
    private val status: Boolean,
    private val message: String,
    private val data: T
)