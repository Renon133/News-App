package com.example.news_app

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NewsAdapter(private val list: List<Article>, private val context: Context) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView ) {
        val newsTitle: TextView = itemView.findViewById(R.id.newsTitle)
        val newsDesc: TextView = itemView.findViewById(R.id.newsDescription)
        val newsImage : ImageView = itemView.findViewById(R.id.newsImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
        return NewsViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.newsTitle.text = list[position].title
        holder.newsDesc.text = list[position].description

        Glide.with(context)
            .load(list[position].urlToImage)
            .into(holder.newsImage)

        holder.itemView.setOnClickListener{
            val intent = Intent(context, ArticleActivity::class.java)
            intent.putExtra("image", list[position].urlToImage)
            intent.putExtra("author", list[position].author)
            intent.putExtra("title", list[position].title)
            intent.putExtra("description", list[position].description)
            intent.putExtra("url", list[position].url)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}