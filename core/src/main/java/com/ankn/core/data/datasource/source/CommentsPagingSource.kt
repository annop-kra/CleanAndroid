package com.ankn.core.data.datasource.source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.ankn.core.domain.model.Comment
import com.ankn.core.domain.repository.CommentRepository


class CommentsPagingSource(
    private val repository: CommentRepository
) : PagingSource<Int, Comment>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Comment> {
        val currentPage = params.key ?: 1
        return try {
            val response = repository.getComments(limit = params.loadSize, page = currentPage)
            val nextPage = if (response.isNotEmpty()) currentPage + 1 else null
            LoadResult.Page(
                data = response,
                prevKey = if (currentPage == 1) null else currentPage - 1,
                nextKey = nextPage
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Comment>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}
