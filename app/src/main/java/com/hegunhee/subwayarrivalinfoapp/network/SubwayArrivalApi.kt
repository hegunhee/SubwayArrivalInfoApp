package com.hegunhee.subwayarrivalinfoapp.network

import com.hegunhee.subwayarrivalinfoapp.data.json.subway_arrival.SubwayArrivalJson
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface SubwayArrivalApi {
    @GET("{key}/{type}/{service}/{start_index}/{end_index}/{station}")
    fun getSubwayInfo(
        @Path("key") key : String,
        @Path("type") type : String = "json",
        @Path("service") service : String = "realtimeStationArrival",
        @Path("start_index") start_index : Int = 1,
        @Path("end_index") end_index : Int = 5,
        @Path("station") station_nm : String
    ) : Call<SubwayArrivalJson>
}