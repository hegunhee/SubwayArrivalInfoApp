package com.hegunhee.subwayarrivalinfoapp.data.json


import com.google.gson.annotations.SerializedName

data class JsonSubwayInfo(
    @SerializedName("SearchInfoBySubwayNameService")
    val searchInfoBySubwayNameService: SearchInfoBySubwayNameService
)