package com.hegunhee.subwayarrivalinfoapp.data.json.subway_info


import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class JsonSubwayInfo(
    @field:Json(name = "SearchInfoBySubwayNameService") val searchInfoBySubwayNameService: SearchInfoBySubwayNameService
)