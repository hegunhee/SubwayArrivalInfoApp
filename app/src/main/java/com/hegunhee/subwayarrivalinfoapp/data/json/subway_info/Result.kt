package com.hegunhee.subwayarrivalinfoapp.data.json.subway_info


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Result(
    @Json(name ="CODE") val code: String,
    @Json(name ="MESSAGE") val message: String
)