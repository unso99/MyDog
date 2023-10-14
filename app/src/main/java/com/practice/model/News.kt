package com.practice.model

data class NewsResponse(
    val response : List<News>
)

data class News(
    val title : String
)
