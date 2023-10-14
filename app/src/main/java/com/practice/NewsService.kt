package com.practice

import com.practice.model.NewsResponse
import io.reactivex.Single
import retrofit2.http.GET

interface NewsService {

    @GET("fb517467-1d68-4a1c-b474-6aff7384d04b")
    fun getNews(): Single<NewsResponse>
}