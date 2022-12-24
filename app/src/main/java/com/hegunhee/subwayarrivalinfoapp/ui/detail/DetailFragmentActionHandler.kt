package com.hegunhee.subwayarrivalinfoapp.ui.detail

import com.hegunhee.subwayarrivalinfoapp.data.entity.Favorites

interface DetailFragmentActionHandler {

    fun deleteFavorite(fullName : String)

    fun insertFavorite(favorite : Favorites)
}