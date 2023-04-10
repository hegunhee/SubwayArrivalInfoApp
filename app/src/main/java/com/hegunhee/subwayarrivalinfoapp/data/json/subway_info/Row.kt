package com.hegunhee.subwayarrivalinfoapp.data.json.subway_info


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Row(
    @Json(name ="FR_CODE") val fr_code: String,
    @Json(name ="LINE_NUM") val line_num: String,
    @Json(name ="STATION_CD") val station_cd: String,
    @Json(name ="STATION_NM") val station_nm: String
) {
}