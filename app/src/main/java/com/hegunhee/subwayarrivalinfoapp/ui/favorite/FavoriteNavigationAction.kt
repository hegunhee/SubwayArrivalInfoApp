package com.hegunhee.subwayarrivalinfoapp.ui.favorite

import com.hegunhee.subwayarrivalinfoapp.data.entity.Favorites

sealed interface FavoriteNavigationAction {

    data class Detail(val favorite : Favorites) : FavoriteNavigationAction
}