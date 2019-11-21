package com.example.myapplication.FindBook

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.TasteBook.HomeTasteViewHolder


class FindBookAdapter (private val context: Context): RecyclerView.Adapter<HomeFindViewHolder>(){

    var data = listOf<BookItem>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeFindViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.home_find_rv_item,parent,false)

        return HomeFindViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: HomeFindViewHolder, position: Int) {
        holder.bind(data[position])
    }
}