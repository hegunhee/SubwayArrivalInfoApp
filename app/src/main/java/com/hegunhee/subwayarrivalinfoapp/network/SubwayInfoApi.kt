package com.hegunhee.subwayarrivalinfoapp.network

import com.hegunhee.subwayarrivalinfoapp.BuildConfig
import com.hegunhee.subwayarrivalinfoapp.data.json.subway_info.JsonSubwayInfo
import retrofit2.http.GET
import retrofit2.http.Path

interface SubwayInfoApi {
    @GET("{key}/{type}/{service}/{start_index}/{end_index}")
    suspend fun getSubwayInfo(
        @Path("key") key : String = BuildConfig.subwayInfoApiKey,
        @Path("type") type : String = "json",
        @Path("service") service : String = "SearchInfoBySubwayNameService",
        @Path("start_index") startIndex : Int = 1,
        @Path("end_index") endIndex : Int = 768,
    ) : JsonSubwayInfo
}