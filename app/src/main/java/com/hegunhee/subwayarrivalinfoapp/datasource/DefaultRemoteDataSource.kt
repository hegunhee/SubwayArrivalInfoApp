package com.hegunhee.subwayarrivalinfoapp.datasource

import com.hegunhee.subwayarrivalinfoapp.data.json.subway_info.JsonSubwayInfo
import com.hegunhee.subwayarrivalinfoapp.network.SubwayInfoApi
import javax.inject.Inject

class DefaultRemoteDataSource @Inject constructor(
    private val subwayInfoApi: SubwayInfoApi
) : RemoteDataSource {
    override suspend fun getAllSubwayList(): JsonSubwayInfo {
        return subwayInfoApi.getSubwayInfo()
    }
}