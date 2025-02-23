package com.ankn.core.domain.usecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.ankn.core.data.datasource.source.CommentsPagingSource
import com.ankn.core.domain.model.Comment
import com.ankn.core.domain.repository.CommentRepository
import kotlinx.coroutines.flow.Flow


class GetCommentsUseCase(
    private val repository: CommentRepository
) {
    operator fun invoke(): Flow<PagingData<Comment>> {
        return Pager(
            config = PagingConfig(pageSize = 10, initialLoadSize = 10, enablePlaceholders = false),
            pagingSourceFactory = { CommentsPagingSource(repository) }
        ).flow
    }
}
