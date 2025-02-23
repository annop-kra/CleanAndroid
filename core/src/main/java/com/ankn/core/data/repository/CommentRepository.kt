package com.ankn.core.data.repository

import com.ankn.core.data.datasource.remote.ApiService
import com.ankn.core.data.datasource.remote.response.toDomain
import com.ankn.core.domain.model.Comment
import com.ankn.core.domain.repository.CommentRepository

class CommentRepositoryImpl(private val apiService: ApiService) : CommentRepository {
    override suspend fun getComments(limit: Int, page: Int): List<Comment> {
        return apiService.getComments(limit, page).map { it.toDomain() }
    }
}
