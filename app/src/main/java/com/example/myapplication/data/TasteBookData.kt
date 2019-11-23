package com.example.myapplication.data

data class TasteBookData(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: List<BookTasteItem>
)

data class BookTasteItem(
    //val idx: Int,//책 인덱스
    //val url: String,//책 이미지
    val title: String,//책 이름
    val author: String,//저자 이름
    val rating: Float,//평점
    val num: String//평가한 사람 수
)