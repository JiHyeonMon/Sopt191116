package com.example.myapplication.data

import com.google.gson.annotations.SerializedName

data class LibraryData(
    @SerializedName("data")
    val data: List<BookLibraryItem>
)
data class BookLibraryItem(
    //val idx: Int,//책 인덱스
    //val url: String,//책 이미지
    val bookname: String,//책 이름
    val author: String,//저자 이름
    val bookcover: String,//책 이미지
    val username: String//평가한 사람 수
)