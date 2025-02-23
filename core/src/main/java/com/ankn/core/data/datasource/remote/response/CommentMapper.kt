package com.ankn.core.data.datasource.remote.response

import com.ankn.core.domain.model.Comment

fun CommentDto.toDomain(): Comment {
    return Comment(
        id = id,
        name = name,
        email = email,
        body = body
    )
}
