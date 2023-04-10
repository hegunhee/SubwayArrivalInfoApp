package com.hegunhee.subwayarrivalinfoapp.network

import com.hegunhee.subwayarrivalinfoapp.BuildConfig
import com.hegunhee.subwayarrivalinfoapp.data.json.subway_arrival.SubwayArrivalJson
import retrofit2.http.GET
import retrofit2.http.Path

interface SubwayArrivalApi {
    @GET("{key}/{type}/{service}/{start_index}/{end_index}/{station}")
    suspend fun getSubwayInfo(
        @Path("key") key : String = BuildConfig.SUBWAY_ARRIVAL_API_KEY,
        @Path("type") type : String = "json",
        @Path("service") service : String = "realtimeStationArrival",
        @Path("start_index") start_index : Int = 1,
        @Path("end_index") end_index : Int = 5,
        @Path("station") station_nm : String
    ) : SubwayArrivalJson
}