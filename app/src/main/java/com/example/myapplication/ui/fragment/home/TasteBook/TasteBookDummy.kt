package com.example.myapplication.ui.fragment.home.TasteBook

import com.example.myapplication.data.BookTasteItem


internal class TasteBookDummy {
    fun bookTasteList() : List<BookTasteItem>{
        return listOf(
            BookTasteItem(
                title = "홀라크라시",
                author = "브라이언 J. 로버트슨 저/김도현...",
                rating = 4.1F,
                num = "23명"
            ),
            BookTasteItem(
                title = "홀라크라시",
                author = "브라이언 J. 로버트슨 저/김도현...",
                rating = 4.1F,
                num = "23명"
            ),
            BookTasteItem(
                title = "홀라크라시",
                author = "브라이언 J. 로버트슨 저/김도현...",
                rating = 4.1F,
                num = "23명"
            )
        )
    }

}