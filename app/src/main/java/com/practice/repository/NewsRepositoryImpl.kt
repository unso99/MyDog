package com.practice.repository

import com.practice.RetrofitManager
import com.practice.model.NewsResponse
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class NewsRepositoryImpl : NewsRepository {
    override fun getNews() = RetrofitManager.newsService.getNews()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}