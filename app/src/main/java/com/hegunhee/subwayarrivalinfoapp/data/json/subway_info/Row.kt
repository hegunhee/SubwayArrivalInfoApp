package com.hegunhee.subwayarrivalinfoapp.data.json.subway_info


import com.google.gson.annotations.SerializedName
import com.hegunhee.subwayarrivalinfoapp.data.entity.SubwayInfoEntity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Row(
    @field:Json(name ="FR_CODE")
    val fr_code: String,
    @field:Json(name ="LINE_NUM")
    val line_num: String,
    @field:Json(name ="STATION_CD")
    val station_cd: String,
    @field:Json(name ="STATION_NM")
    val station_nm: String
) {
}