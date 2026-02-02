package com.example.paginationproject.repository

import com.example.paginationproject.network.NetworkClient
import com.example.paginationproject.network.imageResponse.ImageListModel
import kotlin.text.get

class ImageListRepositoryImpl(
    private val networkClient: NetworkClient,
    //private val mapper: Mapper<Data, News>,
): ImageListRepository {
    override suspend fun getImages(
        page: Int,
        limit: Int
    ): ImageListModel {
        val response: ImageListModel = networkClient.get(
            url = "https://picsum.photos/v2/list" + "?page=$page&limit=$limit",
            responseType = ImageListModel::class
        )

        return response
    }
}