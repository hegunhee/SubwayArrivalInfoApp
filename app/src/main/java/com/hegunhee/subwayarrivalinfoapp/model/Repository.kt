package com.hegunhee.subwayarrivalinfoapp.model

import com.hegunhee.subwayarrivalinfoapp.data.entity.SubwayInfoEntity
import kotlinx.coroutines.flow.Flow

interface Repository {

    suspend fun insertSubwayInfoList(infoList : List<SubwayInfoEntity>)

    suspend fun toggleSubwayInfo(subwayInfoEntity: SubwayInfoEntity)

    fun getAllSubwayInfoListByFlow() : Flow<List<SubwayInfoEntity>>
}