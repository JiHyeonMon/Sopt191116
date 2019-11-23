package com.example.myapplication.TodayBestseller

import android.view.View
import android.widget.AbsListView
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class TodayBestsellerViewHolder(view: View) : RecyclerView.ViewHolder(view)  {
    val img_rv_today_best_seller: ImageView= view.findViewById(R.id.img_rv_today_best_seller)

     fun bind(data: TodayBestsellerData) {
         when {
             data.status == 1 -> img_rv_today_best_seller.setImageResource(R.drawable.best_book_img_1)
             data.status == 2 -> img_rv_today_best_seller.setImageResource(R.drawable.best_book_img_2)
             data.status == 3 -> img_rv_today_best_seller.setImageResource(R.drawable.best_book_img_3)
             else -> img_rv_today_best_seller.setImageResource(R.drawable.best_book_img_1)
         }
     }

}