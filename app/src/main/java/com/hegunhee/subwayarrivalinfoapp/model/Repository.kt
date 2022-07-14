package com.hegunhee.subwayarrivalinfoapp.model

import com.hegunhee.subwayarrivalinfoapp.data.entity.SubwayInfoEntity
import com.hegunhee.subwayarrivalinfoapp.data.json.subway_info.JsonSubwayInfo
import kotlinx.coroutines.flow.Flow
import retrofit2.Call

interface Repository {

    suspend fun insertSubwayInfoList(infoList : List<SubwayInfoEntity>)

    suspend fun toggleSubwayInfo(subwayInfoEntity: SubwayInfoEntity)

    fun getAllSubwayInfoListByFlow() : Flow<List<SubwayInfoEntity>>

    suspend fun getAllSubwayList() : Call<JsonSubwayInfo>
}