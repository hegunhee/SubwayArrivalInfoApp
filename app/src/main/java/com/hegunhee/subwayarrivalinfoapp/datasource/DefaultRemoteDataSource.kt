package com.hegunhee.subwayarrivalinfoapp.datasource

import com.hegunhee.subwayarrivalinfoapp.data.json.subway_arrival.SubwayArrivalResponse
import com.hegunhee.subwayarrivalinfoapp.data.json.subway_info.SubwayInfoResponse
import com.hegunhee.subwayarrivalinfoapp.network.SubwayArrivalApi
import com.hegunhee.subwayarrivalinfoapp.network.SubwayInfoApi
import javax.inject.Inject

class DefaultRemoteDataSource @Inject constructor(
    private val subwayInfoApi: SubwayInfoApi,
    private val subwayArrivalApi: SubwayArrivalApi
) : RemoteDataSource {
    override suspend fun getAllSubwayList(): SubwayInfoResponse {
        return subwayInfoApi.getSubwayInfo()
    }

    override suspend fun getSubwayInfo(stationName: String): SubwayArrivalResponse {
        return subwayArrivalApi.getSubwayInfo(stationName = stationName)
    }
}