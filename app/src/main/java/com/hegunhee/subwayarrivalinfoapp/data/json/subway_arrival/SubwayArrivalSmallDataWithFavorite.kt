package com.hegunhee.subwayarrivalinfoapp.data.json.subway_arrival

import com.hegunhee.subwayarrivalinfoapp.data.entity.Favorites

data class SubwayArrivalSmallDataWithFavorite(
    val nextStation : String,
    val time : Int,
    val message : String,
    val fullName : String,
    val stationLine : String,
    val isFavorite : Boolean
) {

    fun toFavorites(station_name : String) : Favorites{
        return Favorites(fullName,station_name,stationLine)
    }
}