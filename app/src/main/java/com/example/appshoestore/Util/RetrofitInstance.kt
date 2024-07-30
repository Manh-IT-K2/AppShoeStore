package com.example.appshoestore.Util

import com.example.appshoestore.Service.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    var URL_Manh = "https://3rg07cfh-8080.asse.devtunnels.ms/api/"
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(URL_Manh)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}
