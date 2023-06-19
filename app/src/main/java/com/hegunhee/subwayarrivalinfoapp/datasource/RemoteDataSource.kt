package com.hegunhee.subwayarrivalinfoapp.datasource

import com.hegunhee.subwayarrivalinfoapp.data.json.subway_arrival.SubwayArrivalJson
import com.hegunhee.subwayarrivalinfoapp.data.json.subway_info.JsonSubwayInfo

interface RemoteDataSource {

    suspend fun getAllSubwayList() : JsonSubwayInfo

    suspend fun getSubwayInfo(stationName : String) : SubwayArrivalJson

}