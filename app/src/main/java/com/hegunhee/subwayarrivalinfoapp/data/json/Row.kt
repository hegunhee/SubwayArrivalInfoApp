package com.hegunhee.subwayarrivalinfoapp.data.json


import com.google.gson.annotations.SerializedName
import com.hegunhee.subwayarrivalinfoapp.data.entity.SubwayInfoEntity

data class Row(
    @SerializedName("FR_CODE")
    val fr_code: String,
    @SerializedName("LINE_NUM")
    val line_num: String,
    @SerializedName("STATION_CD")
    val station_cd: String,
    @SerializedName("STATION_NM")
    val station_nm: String
) {
}