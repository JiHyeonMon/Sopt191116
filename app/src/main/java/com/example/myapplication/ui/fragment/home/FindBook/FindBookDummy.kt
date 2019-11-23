package com.example.myapplication.ui.fragment.home.FindBook

import com.example.myapplication.data.BookItem

internal class FindBookDummy {
    fun bookList() : List<BookItem>{
        return listOf(
            BookItem(
                title = "홀라크라시",
                author = "브라이언 J. 로버트슨 저/김도현...",
                rating = 4.1F,
                num = "23명"
            ),
            BookItem(
                title = "홀라크라시",
                author = "브라이언 J. 로버트슨 저/김도현...",
                rating = 4.1F,
                num = "23명"
            ),
            BookItem(
                title = "홀라크라시",
                author = "브라이언 J. 로버트슨 저/김도현...",
                rating = 4.1F,
                num = "23명"
            )
        )
    }

}