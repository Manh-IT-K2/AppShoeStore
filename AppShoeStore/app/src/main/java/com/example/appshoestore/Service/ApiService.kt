package com.example.appshoestore.Service

import com.example.appshoestore.Model.Products
import retrofit2.http.GET

interface ApiService {
    @GET("products")
    suspend fun getProducts(): List<Products>
}
