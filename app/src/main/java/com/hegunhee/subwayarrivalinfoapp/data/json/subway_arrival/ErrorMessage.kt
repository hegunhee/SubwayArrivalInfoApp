package com.hegunhee.subwayarrivalinfoapp.data.json.subway_arrival


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ErrorMessage(
    @Json(name ="code") val code: String,
    @Json(name ="developerMessage") val developerMessage: String,
    @Json(name ="link") val link: String,
    @Json(name ="message") val message: String,
    @Json(name ="status") val status: Int,
    @Json(name ="total") val total: Int
)