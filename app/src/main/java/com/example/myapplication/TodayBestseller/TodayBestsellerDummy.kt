package com.example.myapplication.TodayBestseller

internal class TodayBestsellerDummy {
    fun TodayBestsellerList() : List<TodayBestsellerData>{
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