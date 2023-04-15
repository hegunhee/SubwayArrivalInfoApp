package com.hegunhee.subwayarrivalinfoapp.data.json.subway_arrival

data class SubwayArrivalSmallData(
    val nextStation : String,
    val time : Int,
    val message : String,
    val subwayInfo : String,
    val stationLine : String
){
    fun toSubwayArrivalSmallDataWithFavorite(isFavorite : Boolean) : SubwayArrivalSmallDataWithFavorite{
        return SubwayArrivalSmallDataWithFavorite(nextStation,time,message,subwayInfo,stationLine,isFavorite)
    }
}