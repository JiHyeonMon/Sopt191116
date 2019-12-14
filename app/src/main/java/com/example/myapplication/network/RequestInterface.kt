package com.example.myapplication.network

import com.example.myapplication.data.BookData
import com.example.myapplication.data.HashData
import com.example.myapplication.data.LibraryData
import retrofit2.Call
import retrofit2.http.*

interface RequestInterface {
    @FormUrlEncoded
    @POST("/home/book/")//uri
    fun getFindBookData(
        @Field("category")category : String//category에 String 타입 category 값 전달.
    ) : Call<BookData> //validate해서 받는 데이터의 형식.

    @GET("/home/booklike/{username}")//uri
    fun getTasteBookData(
        @Path("username")username : String
    ) : Call<BookData> //validate해서 받는 데이터의 형식.

    @FormUrlEncoded
    @POST("/home/hashtag/")//uri
    fun getHash(
        @Field("username")username : String
    ) : Call<HashData> //validate해서 받는 데이터의 형식.

    @GET("/mypage/mybook/{username}")//uri
    fun getMyBook(
        @Path("username")username : String
    ) : Call<LibraryData> //validate해서 받는 데이터의 형식.
}