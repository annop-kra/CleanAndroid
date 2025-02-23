package com.ankn.cleanandroidtemplate.navigation

import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import com.ankn.cleanandroidtemplate.R
import com.ankn.cleanandroidtemplate.ui.home.HomeFragmentDirections

// presentation/navigation/NavigatorImpl.kt
class NavigatorImpl(
    private val activity: AppCompatActivity,
    private val navController: NavController
) : Navigator {

    private val globalNavOptions = NavOptions.Builder()
        .setEnterAnim(R.anim.slide_in_right) // เลื่อนจากขวาเข้ามา
        .setExitAnim(R.anim.slide_out_left) // เลื่อนออกไปทางซ้าย
        .setPopEnterAnim(R.anim.slide_in_left) // เมื่อกลับมา เลื่อนจากซ้ายเข้ามา
        .setPopExitAnim(R.anim.slide_out_right) // เมื่อกลับมา เลื่อนออกไปทางขวา
        .build()

    override fun navigateTo(destination: NavigationDestination) {
        when (destination) {
            is NavigationDestination.Detail -> {
                val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(destination.itemTitle)
                navController.navigate(action, globalNavOptions) // ใช้ globalNavOptions
            }
            NavigationDestination.Home -> {
                navController.navigate(R.id.homeFragment, globalNavOptions) // ใช้ globalNavOptions
            }
        }
    }

    override fun navigateBack() {
        navController.navigateUp()
    }
}