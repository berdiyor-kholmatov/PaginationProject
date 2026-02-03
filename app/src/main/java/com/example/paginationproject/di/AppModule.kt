package com.example.paginationproject.di

import com.example.paginationproject.network.NetworkClient
import com.example.paginationproject.network.client.NetworkClientImpl
import com.example.paginationproject.repository.ImageListRepository
import com.example.paginationproject.repository.ImageListRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideNetworkClientImpl(): NetworkClientImpl {
        val client = HttpClient(OkHttp)
        {
            install(ContentNegotiation)
            {
                json(
                    Json { ignoreUnknownKeys = true }
                )
            }
        }

        return NetworkClientImpl(client)
    }

    //for future testing
    @Provides
    fun provideNetworkClient(
        realNetworkClient: NetworkClientImpl
    ): NetworkClient {
        return realNetworkClient
    }

    //for future testing
    @Provides
    fun provideImageListRepository(
        imageListRepositoryImpl: ImageListRepositoryImpl
    ): ImageListRepository {
        return imageListRepositoryImpl
    }


}