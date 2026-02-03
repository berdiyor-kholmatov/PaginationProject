package com.example.paginationproject.repository

import android.util.Log
import com.example.paginationproject.network.NetworkClient
import com.example.paginationproject.network.imageResponse.ImageListModel
import com.example.paginationproject.network.imageResponse.ImageListModelItem
import javax.inject.Inject
import kotlin.text.get

class ImageListRepositoryImpl @Inject constructor(
    private val networkClient: NetworkClient,
    //private val mapper: Mapper<Data, News>,
): ImageListRepository {
    override suspend fun getImages(
        page: Int,
        limit: Int
    ): List<ImageListModelItem> {
        val response: List<ImageListModelItem> = networkClient.get(
            url = "https://picsum.photos/v2/list" + "?page=$page&limit=$limit",
            //responseType = ImageListModel::class
        )

        Log.d("test", "executed ${response}")

        return response
    }
}