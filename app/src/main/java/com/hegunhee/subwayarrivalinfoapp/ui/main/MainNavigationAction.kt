package com.hegunhee.subwayarrivalinfoapp.ui.main

sealed interface MainNavigationAction {

    data class Detail(val subwayName : String) : MainNavigationAction

    object Favorite : MainNavigationAction
}