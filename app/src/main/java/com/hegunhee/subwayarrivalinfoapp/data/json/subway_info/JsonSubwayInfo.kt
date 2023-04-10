package com.hegunhee.subwayarrivalinfoapp.data.json.subway_info


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class JsonSubwayInfo(
    @Json(name = "SearchInfoBySubwayNameService") val searchInfoBySubwayNameService: SearchInfoBySubwayNameService
)