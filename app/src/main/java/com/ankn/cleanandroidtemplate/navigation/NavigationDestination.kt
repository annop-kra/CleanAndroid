package com.ankn.cleanandroidtemplate.navigation

sealed class NavigationDestination {
    data class Detail(val itemTitle: String) : NavigationDestination()
    object Home : NavigationDestination()
}