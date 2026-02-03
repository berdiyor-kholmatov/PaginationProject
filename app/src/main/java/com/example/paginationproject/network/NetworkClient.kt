package com.example.paginationproject.network

import com.example.paginationproject.network.imageResponse.ImageListModel
import com.example.paginationproject.network.imageResponse.ImageListModelItem
import java.io.Closeable
import kotlin.reflect.KClass

interface NetworkClient : Closeable  {
    suspend fun <T : Any> get(
        url: String,
        headers: Map<String, String> = emptyMap(),
        responseType: KClass<T>
    ) : T

    suspend fun get(
        url: String,
        headers: Map<String, String> = emptyMap(),
    ) : List<ImageListModelItem>
}