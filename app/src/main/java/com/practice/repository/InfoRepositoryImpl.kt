package com.practice.repository

import com.practice.RetrofitManager
import com.practice.model.Info
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class InfoRepositoryImpl : InfoRepository {
    override fun getInfo() = RetrofitManager.infoService.getInfo()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}