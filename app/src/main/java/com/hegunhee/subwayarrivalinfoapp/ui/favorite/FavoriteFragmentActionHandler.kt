package com.hegunhee.subwayarrivalinfoapp.ui.favorite

import com.hegunhee.subwayarrivalinfoapp.data.entity.Favorites

interface FavoriteFragmentActionHandler {

    fun showDetailFavorite(favorite: Favorites)

    fun deleteFavorite(stationInfo : String)


}