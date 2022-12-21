package com.hegunhee.subwayarrivalinfoapp.data.json.subway_info


import com.google.gson.annotations.SerializedName
import com.hegunhee.subwayarrivalinfoapp.data.json.subway_info.Result
import com.hegunhee.subwayarrivalinfoapp.data.json.subway_info.Row
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SearchInfoBySubwayNameService(
    @field:Json(name ="list_total_count") val listTotalCount: Int,
    @field:Json(name ="RESULT") val result: Result,
    @field:Json(name ="row") val row: List<Row>
)