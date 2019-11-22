package com.example.myapplication.TodayBestseller

internal class TodaybestsellerDummy {
    fun bookTasteList() : List<TodayBestsellerData>{
        return listOf(
            TodayBestsellerData(
                status = 1
            ), TodayBestsellerData(
                status = 2
            ),
            TodayBestsellerData(
                status = 3
            )
        )
    }
}