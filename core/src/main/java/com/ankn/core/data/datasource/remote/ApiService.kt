package com.ankn.core.data.datasource.remote

import com.ankn.core.data.datasource.remote.response.CommentDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("comments")
    suspend fun getComments(@Query("_limit") limit: Int, @Query("_page") page: Int): List<CommentDto>
}
