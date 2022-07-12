package com.hegunhee.subwayarrivalinfoapp.data.json


import com.google.gson.annotations.SerializedName

data class SearchInfoBySubwayNameService(
    @SerializedName("list_total_count")
    val listTotalCount: Int,
    @SerializedName("RESULT")
    val result: Result,
    @SerializedName("row")
    val row: List<Row>
)