package com.example.news_app

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsInterface {

    @GET("v2/top-headlines")
    fun fetchHeadlines(@Query("country") countryName: String, @Query("apiKey") apiKey: String): Call<News>

    //
    @GET("v2/everything")
    fun fetchEveryNews(@Query("q") topic: String, @Query("apiKey") apiKey: String): Call<News>
}