package com.example.a10week.interfaces

import com.example.a10week.models.PublicHolidays
import com.example.a10week.models.ServerTime
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DateApiService {
    @GET("/api/v2/publicholidays/{year}/{locale}")
    fun getHolidays(
        @Path("year") year: String,
        @Path("locale") locale: String
    ): Call<List<PublicHolidays>>

//    @GET("/api/1/test/user")
//    fun userCheck(
//        @Query("id") id: String,
//        @Query("pwd") pwd: String,
//    ): Call<UserCheck>

    @GET("api/v1/test/datetime")
    fun serverTime():Call<String>
//    @GET("api/1/test/datetime")
//    fun serverTime():Call<ServerTime>



}