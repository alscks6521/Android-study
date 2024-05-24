package com.example.a10week.models

import android.content.ContentProvider.PipeDataWriter
import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("ID") val ID: String,
    @SerializedName("PWD") val PWD: String,
)
