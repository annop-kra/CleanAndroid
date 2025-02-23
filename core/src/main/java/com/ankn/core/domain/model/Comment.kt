package com.ankn.core.domain.model

data class Comment(
    val id: Int,
    val name: String,
    val email: String,
    val body: String
)