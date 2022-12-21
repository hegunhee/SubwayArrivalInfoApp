package com.hegunhee.subwayarrivalinfoapp.data.json.subway_arrival


import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import retrofit2.http.Field

@JsonClass(generateAdapter = true)
data class SubwayArrivalJson(
    @field:Json(name = "errorMessage") val errorMessage: ErrorMessage,
    @field:Json(name ="realtimeArrivalList") val realtimeArrivalList: List<RealtimeArrival>
)