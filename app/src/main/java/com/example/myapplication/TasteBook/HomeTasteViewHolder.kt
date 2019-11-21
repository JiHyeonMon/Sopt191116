package com.example.myapplication.TasteBook
import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R

class HomeTasteViewHolder (view: View) : RecyclerView.ViewHolder(view) {

        //val rv_homeTaste_item: View = view.findViewById(R.id.rv_homeTaste)
        val homeTaste_img_book: ImageView = view.findViewById(R.id.homeTaste_img_book)
        val homeTaste_txt_book: TextView = view.findViewById(R.id.homeTaste_txt_book)
        val homeTaste_txt_author: TextView = view.findViewById(R.id.homeTaste_txt_author)
        val homeTaste_ratingbar : RatingBar = view.findViewById(R.id.homeTaste_ratingbar)
        val homeTaste_txt_rating: TextView = view.findViewById(R.id.homeTaste_txt_rating)
        val homeTaste_checkbox: ImageView = view.findViewById(R.id.homeTaste_checkbox)

        fun bind(data: BookTasteItem) {
            //Glide.with(itemView).load(data.url).into(homeFind_img_book)
            homeTaste_txt_book.text = data.title
            homeTaste_txt_author.text = data.author
            homeTaste_ratingbar.rating = data.rating
            homeTaste_txt_rating.text = data.rating.toString()+" ("+data.num+")"
        }

}