package com.hegunhee.subwayarrivalinfoapp.data.json.subway_arrival

import com.hegunhee.subwayarrivalinfoapp.data.entity.Favorites

data class SubwayArrivalSmallDataWithStationLine(
    val nextStation : String,
    val time : Int,
    val message : String,
    val fullName : String,
    val station_line : String,
    val isFavorite : Boolean
) {

    fun toFavorites(station_name : String) : Favorites{
        return Favorites(fullName,station_name,station_line)
    }
}