package com.example.paginationproject.ui.imagesList

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.paginationproject.repository.ImageListRepository
import com.example.paginationproject.repository.paging.ImagesDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ImageListViewModel @Inject constructor (
    private val repository: ImageListRepository
): ViewModel() {
    init{
        viewModelScope.launch {
           // Log.d("test", "executed: ${repository.getImages(1, 10)}")
        }

    }
    val usersPager = Pager(
        PagingConfig(10),
        pagingSourceFactory = { ImagesDataSource(repository) }
    ).flow.cachedIn(viewModelScope)
}
