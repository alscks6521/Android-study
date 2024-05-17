package com.example.a10week.interfaces

import com.example.a10week.models.PublicHolidays
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface DateApiService {
    @GET("/api/v2/publicholidays/{year}/{locale}")
    fun getHolidays(
        @Path("year") year: String,
        @Path("locale") locale: String
    ): Call<List<PublicHolidays>>
}