package com.hegunhee.subwayarrivalinfoapp.data.json.subway_info


import com.google.gson.annotations.SerializedName
import com.hegunhee.subwayarrivalinfoapp.data.json.subway_info.Result
import com.hegunhee.subwayarrivalinfoapp.data.json.subway_info.Row

data class SearchInfoBySubwayNameService(
    @SerializedName("list_total_count")
    val listTotalCount: Int,
    @SerializedName("RESULT")
    val result: Result,
    @SerializedName("row")
    val row: List<Row>
)