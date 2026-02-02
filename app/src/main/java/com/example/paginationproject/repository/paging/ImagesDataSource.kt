package com.example.paginationproject.repository.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.paginationproject.network.imageResponse.ImageListModel
import com.example.paginationproject.network.imageResponse.ImageListModelItem
import com.example.paginationproject.repository.ImageListRepository

class ImagesDataSource(
    private val repository: ImageListRepository
): PagingSource<Int, ImageListModelItem>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ImageListModelItem> {
        return try {
            val page = params.key ?: 1
            val response = repository.getImages(page, params.loadSize)
            LoadResult.Page(
                data = response,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (response.isEmpty()) null else page + 1
            )
        }catch (e: Exception){
            return LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, ImageListModelItem>): Int? {
        return  state.anchorPosition?.let { position ->
            val page = state.closestPageToPosition(position)
            page?.prevKey?.plus(1) ?: page?.nextKey?.minus(1)
        }
    }
}