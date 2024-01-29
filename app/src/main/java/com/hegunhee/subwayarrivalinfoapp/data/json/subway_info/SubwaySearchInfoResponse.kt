package com.hegunhee.subwayarrivalinfoapp.data.json.subway_info

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SubwaySearchInfoResponse(
    @Json(name ="list_total_count") val listTotalCount: Int,
    @Json(name ="RESULT") val result: Result,
    @Json(name ="row") val row: List<Row>
)