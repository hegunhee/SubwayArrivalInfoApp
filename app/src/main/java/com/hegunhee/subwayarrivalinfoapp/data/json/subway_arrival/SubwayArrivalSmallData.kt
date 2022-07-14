package com.hegunhee.subwayarrivalinfoapp.data.json.subway_arrival

data class SubwayArrivalSmallData(
    val nextStation : String,
    val time : Int,
    val message : String,
    val fullName : String
){
    fun toWithStationLine(station_line : String) : SubwayArrivalSmallDataWithStationLine{
        return SubwayArrivalSmallDataWithStationLine(nextStation,time,message,fullName,station_line)
    }
}