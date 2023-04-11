package com.hegunhee.subwayarrivalinfoapp.network

import com.hegunhee.subwayarrivalinfoapp.BuildConfig
import com.hegunhee.subwayarrivalinfoapp.data.json.subway_info.JsonSubwayInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface SubwayInfoApi {
    @GET("/{key}/{type}/{service}/{start_index}/{end_index}")
    suspend fun getSubwayInfo(
        @Path("key") key : String = BuildConfig.SUBWAY_INFO_API_KEY,
        @Path("type") type : String = "json",
        @Path("service") service : String = "SearchInfoBySubwayNameService",
        @Path("start_index") start_index : Int = 1,
        @Path("end_index") end_inedx : Int = 768,
    ) : JsonSubwayInfo
}