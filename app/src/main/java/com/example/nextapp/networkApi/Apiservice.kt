package com.example.nextapp.networkApi

import com.example.nextapp.UI.MainActivity
import com.example.nextapp.model.loginModel
import com.example.nextapp.model.vehicalModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST

interface Apiservice {

    @FormUrlEncoded
    @POST("token")
    @Headers(
        "RequestAPIClient:QcheckApp",
        "Content-Type:application/x-www-form-urlencoded"
    )
    fun getLogindetail(
        @Field("UserName") UserName:String?,
        @Field("password") password:String?,
        @Field("grant_type") grant_type:String?
    ):Call<loginModel>


    @FormUrlEncoded
    @POST("api/boordComputer/GetVicinityVehicles")

    @Headers(
        "Content-Type:application/x-www-form-urlencoded"

    )
    fun getvehicalData(
        @Field("Latitude") Latitude:String?,
        @Field("RequestTime") RequestTime:String?,
        @Field("Longitude") Longitude:String?,
        @Field("Radius") Radius:String?
    ):Call<vehicalModel>
}