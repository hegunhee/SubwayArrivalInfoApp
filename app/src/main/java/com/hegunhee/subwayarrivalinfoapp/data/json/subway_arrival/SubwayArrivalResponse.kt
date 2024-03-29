package com.hegunhee.subwayarrivalinfoapp.data.json.subway_arrival


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SubwayArrivalResponse(
    @Json(name = "errorMessage") val errorMessage: ErrorMessage?,
    @Json(name = "realtimeArrivalList") val realtimeArrivalResponseList: List<RealtimeArrivalResponse>
)