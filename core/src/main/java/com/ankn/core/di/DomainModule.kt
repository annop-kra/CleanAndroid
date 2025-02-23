package com.ankn.core.di

import com.ankn.core.domain.usecase.GetCommentsUseCase
import org.koin.dsl.module

val domainModule = module {
    single { GetCommentsUseCase(get()) }
}