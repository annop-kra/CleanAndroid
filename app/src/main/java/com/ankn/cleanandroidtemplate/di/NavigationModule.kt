package com.ankn.cleanandroidtemplate.di

import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import com.ankn.cleanandroidtemplate.navigation.Navigator
import com.ankn.cleanandroidtemplate.navigation.NavigatorImpl
import org.koin.dsl.module

val navigationModule = module {
    factory<Navigator> { (activity: AppCompatActivity, navController: NavController) ->
        NavigatorImpl(activity, navController)
    }
}