package com.example.myapplication.ui.fragment.home.TasteBook

import com.example.myapplication.data.BookItem


internal class TasteBookDummy {
    fun bookTasteList() : List<BookItem>{
        return listOf(
            BookItem(
                bookname = "홀라크라시",
                author = "브라이언 J. 로버트슨 저/김도현...",
                bookcover = "",
                star = 4.1F
            ),
            BookItem(
                bookname = "홀라크라시",
                author = "브라이언 J. 로버트슨 저/김도현...",
                bookcover = "",
                star = 4.1F
            ),
            BookItem(
                bookname = "홀라크라시",
                author = "브라이언 J. 로버트슨 저/김도현...",
                bookcover = "",
                star = 4.1F
            )
        )
    }

}