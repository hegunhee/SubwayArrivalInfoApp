package com.hegunhee.subwayarrivalinfoapp.data.json.subway_info


import com.google.gson.annotations.SerializedName

data class JsonSubwayInfo(
    @SerializedName("SearchInfoBySubwayNameService")
    val searchInfoBySubwayNameService: SearchInfoBySubwayNameService
)