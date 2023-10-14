package com.practice

import android.telecom.Call
import com.practice.model.Image
import com.practice.model.ImageResponse
import io.reactivex.Single
import retrofit2.http.GET

interface ImageService {

    @GET("5d65c00b-4f4c-4178-9288-2be0b3e685c8")
    fun getImage() : Single<ImageResponse>
}