package com.practice.repository

import com.practice.model.Info
import io.reactivex.Single

interface InfoRepository {

    fun getInfo() : Single<Info>
}