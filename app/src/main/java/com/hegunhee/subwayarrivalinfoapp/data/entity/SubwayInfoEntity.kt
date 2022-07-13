package com.hegunhee.subwayarrivalinfoapp.data.entity


data class SubwayInfoEntity(
    val subwayName : String,
    val subwayLine : List<String>,
    val isBookmarked : Boolean = false
) {
}