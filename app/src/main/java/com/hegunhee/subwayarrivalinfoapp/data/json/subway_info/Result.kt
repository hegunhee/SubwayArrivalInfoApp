package com.hegunhee.subwayarrivalinfoapp.data.json.subway_info


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("CODE")
    val code: String,
    @SerializedName("MESSAGE")
    val message: String
)