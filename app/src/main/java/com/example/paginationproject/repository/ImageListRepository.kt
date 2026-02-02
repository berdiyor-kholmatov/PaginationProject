package com.example.paginationproject.repository

//import androidx.paging.PagingData
import com.example.paginationproject.network.imageResponse.ImageListModel
import kotlinx.coroutines.flow.Flow

interface ImageListRepository {
    suspend fun getImages(page: Int, limit: Int): ImageListModel
}


