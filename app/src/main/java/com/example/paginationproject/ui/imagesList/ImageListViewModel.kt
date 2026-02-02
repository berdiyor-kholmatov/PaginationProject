package com.example.paginationproject.ui.imagesList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.paginationproject.repository.ImageListRepository
import com.example.paginationproject.repository.paging.ImagesDataSource
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class ImageListViewModel(
    private val repository: ImageListRepository
): ViewModel() {
    val usersPager = Pager(
        PagingConfig(10),
        pagingSourceFactory = { ImagesDataSource(repository) }
    ).flow.cachedIn(viewModelScope)
}
