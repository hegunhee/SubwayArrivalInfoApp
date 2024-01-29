package com.hegunhee.subwayarrivalinfoapp.datasource

import com.hegunhee.subwayarrivalinfoapp.data.json.subway_arrival.SubwayArrivalResponse
import com.hegunhee.subwayarrivalinfoapp.data.json.subway_info.SubwayInfoResponse

interface RemoteDataSource {

    suspend fun getAllSubwayList() : SubwayInfoResponse

    suspend fun getSubwayInfo(stationName : String) : SubwayArrivalResponse

}