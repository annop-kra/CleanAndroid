package com.ankn.cleanandroidtemplate.navigation

interface Navigator {
    fun navigateTo(destination: NavigationDestination)
    fun navigateBack()
}