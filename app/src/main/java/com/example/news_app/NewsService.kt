package com.example.news_app

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NewsService {
    private val retrofit = Retrofit.Builder()
        .baseUrl(CONSTANT.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val newsInstance: NewsInterface = retrofit.create(NewsInterface::class.java)
}