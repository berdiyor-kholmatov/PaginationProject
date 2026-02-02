package com.example.paginationproject.damain.model

data class Image (
    val id: String,
    val author: String,
    val width: Int,
    val height: Int,
    val url: String,
    val download_url: String,
)