package com.hegunhee.subwayarrivalinfoapp.network

import com.hegunhee.subwayarrivalinfoapp.BuildConfig
import com.hegunhee.subwayarrivalinfoapp.data.json.subway_arrival.SubwayArrivalResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface SubwayArrivalApi {
    @GET("{key}/{type}/{service}/{start_index}/{end_index}/{station}")
    suspend fun getSubwayInfo(
        @Path("key") key : String = BuildConfig.subwayArrivalApiKey,
        @Path("type") type : String = "json",
        @Path("service") service : String = "realtimeStationArrival",
        @Path("start_index") startIndex : Int = 1,
        @Path("end_index") endIndex : Int = 5,
        @Path("station") stationName : String
    ) : SubwayArrivalResponse
}