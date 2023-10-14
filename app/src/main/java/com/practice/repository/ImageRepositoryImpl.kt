package com.practice.repository

import android.util.Log
import com.practice.RetrofitManager
import com.practice.model.Image
import com.practice.model.ImageResponse
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers

class ImageRepositoryImpl : ImageRepository {
    override fun getImage() = RetrofitManager.imageService.getImage()
        .subscribeOn(Schedulers.io()) //백그라운드 쓰레드 작업
        .observeOn(AndroidSchedulers.mainThread()) //변경은 main에서
}