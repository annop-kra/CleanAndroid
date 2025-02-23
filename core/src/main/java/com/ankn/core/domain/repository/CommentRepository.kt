package com.ankn.core.domain.repository

import com.ankn.core.domain.model.Comment

interface CommentRepository {
    suspend fun getComments(limit: Int, page: Int): List<Comment>
}