package com.example.paginationproject.ui.imagesList

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.paginationproject.network.client.NetworkClientImpl
import com.example.paginationproject.network.imageResponse.ImageListModel
import com.example.paginationproject.network.imageResponse.ImageListModelItem
import com.example.paginationproject.repository.ImageListRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json


@Composable
fun ImagesList(){
    val client = HttpClient(OkHttp)
    {
        install(ContentNegotiation)
        {
            json(
                Json { ignoreUnknownKeys = true }
            )
        }
    }

    val repo = ImageListRepositoryImpl(networkClient = NetworkClientImpl(client))

    var isLoading = false
    var images: List<ImageListModelItem>? = null
        runBlocking {
            isLoading = true
            images = repo.getImages(page = 1, limit = 10).toList()
            isLoading = false
        }

    if (!isLoading && images != null) {
        LazyColumn{
            items(images.size) { item ->
                AsyncImage(
                    model = images[item].url,
                    contentDescription = images[item].author,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(230.dp),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }


}