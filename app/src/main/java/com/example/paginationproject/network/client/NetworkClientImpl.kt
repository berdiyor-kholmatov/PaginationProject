package com.example.paginationproject.network.client

import com.example.paginationproject.network.NetworkClient
import com.example.paginationproject.network.imageResponse.ImageListModel
import com.example.paginationproject.network.imageResponse.ImageListModelItem
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.statement.HttpResponse
import io.ktor.util.reflect.TypeInfo
import jakarta.inject.Inject
import kotlin.reflect.KClass

class NetworkClientImpl @Inject constructor(
    private val httpClient: HttpClient,
): NetworkClient {

    override fun close() {
        httpClient.close()
    }

    override suspend fun <T : Any> get(
        url: String,
        headers: Map<String, String>,
        responseType: KClass<T>
    ): T {
        val response: HttpResponse = httpClient.get(url)
        {
            headers.forEach { (key, value) -> header(key, value) }
        }
        return response.body(TypeInfo(type = responseType))
    }

    override suspend fun get(
        url: String,
        headers: Map<String, String>
    ): List<ImageListModelItem> {
        val response: HttpResponse = httpClient.get(url)
        {
            headers.forEach { (key, value) -> header(key, value) }
        }
        return response.body()
    }
}