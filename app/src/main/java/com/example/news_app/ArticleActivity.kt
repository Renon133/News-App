package com.example.news_app

import android.content.Intent
import android.media.Image
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.browser.customtabs.CustomTabsIntent
import com.bumptech.glide.Glide

class ArticleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)

        val image = intent.getStringExtra("image")
        val author = intent.getStringExtra("author")
        val title = intent.getStringExtra("title")
        val description = intent.getStringExtra("description")
        val urlToArticle = intent.getStringExtra("url")

        val articleImg : ImageView = findViewById(R.id.imageView)
        val articleAuthor : TextView = findViewById(R.id.author)
        val articleTitle : TextView = findViewById(R.id.titleNews)
        val articleDesc : TextView = findViewById(R.id.articleDesc)

        if(author?.isEmpty() == true) {
            articleAuthor.visibility = View.GONE
        }else{
            articleAuthor.visibility = View.VISIBLE
        }


        Glide.with(this)
            .load(image)
            .into(articleImg)

        articleImg.setOnClickListener{
//            val link_open = Intent(Intent.ACTION_VIEW, Uri.parse(urlToHost))
//            startActivity(link_open)
            val customChromeTab = CustomTabsIntent.Builder().build()
            customChromeTab.launchUrl(this, Uri.parse(urlToArticle))
        }

        articleAuthor.text = author
        articleTitle.text = title
        articleDesc.text = description

    }
}