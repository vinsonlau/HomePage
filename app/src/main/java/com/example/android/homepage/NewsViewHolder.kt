package com.example.android.homepage

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_add_news.view.*

class NewsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    fun bindNews(news:News?){
        with(news!!){
            itemView.editTextLink.setText(link)
            itemView.editTextTitle.setText(title)
        }
    }
}