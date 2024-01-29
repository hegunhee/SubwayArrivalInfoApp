package com.hegunhee.subwayarrivalinfoapp.data.json.subway_info


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Row(
    @Json(name ="FR_CODE") val frCode: String,
    @Json(name ="LINE_NUM") val lineNum: String,
    @Json(name ="STATION_CD") val stationCd: String,
    @Json(name ="STATION_NM") val stationNm: String
) {
    fun getFormattedLineNum() = lineNum.substring(1)
}