package com.hegunhee.subwayarrivalinfoapp.model

import com.hegunhee.subwayarrivalinfoapp.data.entity.Favorites

data class SubwayArrivalInfo(
    val nextStation : String,
    val time : Int,
    val message : String,
    val fullName : String,
    val stationLine : String,
    val isFavorite : Boolean
) {

    fun toFavorites(stationName : String) : Favorites{
        return Favorites(fullName,stationName,stationLine)
    }
}