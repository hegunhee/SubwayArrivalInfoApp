package com.hegunhee.subwayarrivalinfoapp.data.json.subway_info


import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Result(
    @field:Json(name ="CODE") val code: String,
    @field:Json(name ="MESSAGE") val message: String
)