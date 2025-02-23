package com.ankn.core.di

import com.ankn.core.common.util.ServiceFactory
import com.ankn.core.data.repository.CommentRepositoryImpl
import com.ankn.core.domain.repository.CommentRepository
import org.koin.dsl.module

val dataModule = module {
    // Retrofit
    single { ServiceFactory.create(true, get<CoreConfig>().baseUrl) }
    single<CommentRepository> { CommentRepositoryImpl(get()) }
}


