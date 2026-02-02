package com.example.paginationproject.ui.imagesList

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemContentType
import androidx.paging.compose.itemKey
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
fun ImagesList(viewModel: ImageListViewModel){

    val imagesList = viewModel.usersPager.collectAsLazyPagingItems()

    LazyColumn{
        items(
            imagesList.itemCount,
            key = imagesList.itemKey {it.id},
            contentType = imagesList.itemContentType { "image" }
        ){ index: Int ->
            val item = imagesList[index]
            if (item != null) {
                AsyncImage(
                    model = item.url,
                    contentDescription = item.author,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(230.dp),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }

}