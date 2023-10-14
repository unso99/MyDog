package com.practice.repository

import com.practice.model.NewsResponse
import io.reactivex.Single

interface NewsRepository {

    fun getNews() : Single<NewsResponse>
}