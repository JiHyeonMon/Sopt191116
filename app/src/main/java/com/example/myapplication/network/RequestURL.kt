package com.example.myapplication.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RequestURL{
    private const val BASE_URL = "http://hhhhm832e_.pem%20ubuntu@52.91.187.211:3000"//API 주소

    private val retrofit : Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val service : RequestInterface = retrofit.create(RequestInterface::class.java)
}