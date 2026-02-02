package com.example.paginationproject.network

import java.io.Closeable
import kotlin.reflect.KClass

interface NetworkClient : Closeable  {
    suspend fun <T : Any> get(
        url: String,
        headers: Map<String, String> = emptyMap(),
        responseType: KClass<T>
    ) : T
}