package com.example.paginationproject.network.imageResponse

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ImageListModelItem(
    @SerialName("id")
    val id: String,
    @SerialName("author")
    val author: String,
    @SerialName("width")
    val width: Int,
    @SerialName("height")
    val height: Int,
    @SerialName("url")
    val url: String,
    @SerialName("download_url")
    val download_url: String,
)
