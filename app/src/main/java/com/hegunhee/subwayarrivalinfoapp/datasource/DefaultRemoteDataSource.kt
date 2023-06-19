package com.hegunhee.subwayarrivalinfoapp.datasource

import com.hegunhee.subwayarrivalinfoapp.data.json.subway_arrival.SubwayArrivalJson
import com.hegunhee.subwayarrivalinfoapp.data.json.subway_info.JsonSubwayInfo
import com.hegunhee.subwayarrivalinfoapp.network.SubwayArrivalApi
import com.hegunhee.subwayarrivalinfoapp.network.SubwayInfoApi
import javax.inject.Inject

class DefaultRemoteDataSource @Inject constructor(
    private val subwayInfoApi: SubwayInfoApi,
    private val subwayArrivalApi: SubwayArrivalApi
) : RemoteDataSource {
    override suspend fun getAllSubwayList(): JsonSubwayInfo {
        return subwayInfoApi.getSubwayInfo()
    }

    override suspend fun getSubwayInfo(stationName: String): SubwayArrivalJson {
        return subwayArrivalApi.getSubwayInfo(stationName = stationName)
    }
}