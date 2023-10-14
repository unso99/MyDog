package com.practice.repository

import com.practice.model.ImageResponse
import io.reactivex.Single

interface ImageRepository {

    fun getImage() : Single<ImageResponse>
}