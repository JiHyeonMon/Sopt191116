package com.example.myapplication.TodayBestseller

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class TodaybestsellerViewAdapter(private val context: Context):RecyclerView.Adapter<TodayBestsellerViewHolder>() {

    var data = listOf<TodayBestsellerData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):TodayBestsellerViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.today_bestseller_rv_item, parent, false)
        return TodayBestsellerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: TodayBestsellerViewHolder, position: Int) {
        holder.bind(data[position])
    }
}