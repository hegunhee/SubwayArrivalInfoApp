package com.hegunhee.subwayarrivalinfoapp.data.json.subway_arrival

data class SubwayArrivalSmallDataWithStationLine(
    val nextStation : String,
    val time : Int,
    val message : String,
    val fullName : String,
    val station_line : String
) {
}