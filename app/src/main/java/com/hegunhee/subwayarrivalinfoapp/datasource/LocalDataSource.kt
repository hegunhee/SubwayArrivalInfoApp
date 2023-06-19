package com.hegunhee.subwayarrivalinfoapp.datasource

import com.hegunhee.subwayarrivalinfoapp.data.entity.SubwayInfoEntity
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    suspend fun insertSubwayInfoList(infoList : List<SubwayInfoEntity>)

    suspend fun updateSubwayInfoBookMark(subwayInfoEntity: SubwayInfoEntity)

    fun getAllSubwayInfoListByFlow() : Flow<List<SubwayInfoEntity>>

    suspend fun getSubwayInfoByNameOrNull(stationName : String) : SubwayInfoEntity?



}