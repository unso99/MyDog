package com.practice

import android.telecom.Call
import com.practice.model.Image
import com.practice.model.ImageResponse
import io.reactivex.Single
import retrofit2.http.GET

interface ImageService {

    @GET("a12354e9-1f7a-4abc-9c2d-ed16fa67634d")
    fun getImage() : Single<ImageResponse>
}