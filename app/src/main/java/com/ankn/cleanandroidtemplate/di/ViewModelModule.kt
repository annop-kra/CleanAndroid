package com.ankn.cleanandroidtemplate.di

import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import com.ankn.cleanandroidtemplate.navigation.Navigator
import com.ankn.cleanandroidtemplate.ui.home.HomeViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { (activity: AppCompatActivity, navController: NavController) ->
        HomeViewModel(get<Navigator> { parametersOf(activity, navController) }, get())
    }
}