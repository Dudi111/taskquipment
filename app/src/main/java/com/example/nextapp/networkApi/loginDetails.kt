package com.example.nextapp.networkApi

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object loginDetails {

    val httploggingintercepter= HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    private fun getretrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl( "https://qappwebapi-test.quipment.nl/").addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder().addInterceptor(httploggingintercepter).build()).build()
    }
    fun getapiservice()= getretrofit().create(Apiservice::class.java)
}