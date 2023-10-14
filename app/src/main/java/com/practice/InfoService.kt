package com.practice

import com.practice.model.Info
import io.reactivex.Single
import retrofit2.http.GET

interface InfoService {

    @GET("c3011389-98d4-4e62-90be-7c876404704d")
    fun getInfo() : Single<Info>
}