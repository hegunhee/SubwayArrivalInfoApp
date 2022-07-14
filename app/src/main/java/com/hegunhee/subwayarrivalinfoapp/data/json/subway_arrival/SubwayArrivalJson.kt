package com.hegunhee.subwayarrivalinfoapp.data.json.subway_arrival


import com.google.gson.annotations.SerializedName

data class SubwayArrivalJson(
    @SerializedName("errorMessage")
    val errorMessage: ErrorMessage,
    @SerializedName("realtimeArrivalList")
    val realtimeArrivalList: List<RealtimeArrival>
)