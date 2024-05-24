package com.example.a10week.models

import com.google.gson.annotations.SerializedName
import java.util.Date

data class ServerTime(
    @SerializedName("code") val code: Int,
    @SerializedName("msg") val msg: String,
    @SerializedName("date") val date: String,
)
