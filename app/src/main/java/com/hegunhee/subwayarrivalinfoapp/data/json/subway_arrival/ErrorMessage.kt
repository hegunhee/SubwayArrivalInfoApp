package com.hegunhee.subwayarrivalinfoapp.data.json.subway_arrival


import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ErrorMessage(
    @field:Json(name ="code")
    val code: String,
    @field:Json(name ="developerMessage")
    val developerMessage: String,
    @field:Json(name ="link")
    val link: String,
    @field:Json(name ="message")
    val message: String,
    @field:Json(name ="status")
    val status: Int,
    @field:Json(name ="total")
    val total: Int
)