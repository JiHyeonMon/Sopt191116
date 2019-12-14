package com.example.myapplication.data

import com.google.gson.annotations.SerializedName

data class HashData(
    @SerializedName("data")
    val data : List<HashDataSet>
)

data class HashDataSet(
    @SerializedName("image")
    val image : String,
    @SerializedName("main_keyword")
    val main_keyword : String,
    @SerializedName("keywords")
    val keywords : String
)