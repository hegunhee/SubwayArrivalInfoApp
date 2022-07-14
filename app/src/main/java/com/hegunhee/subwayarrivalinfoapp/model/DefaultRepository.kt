package com.hegunhee.subwayarrivalinfoapp.model

import com.hegunhee.subwayarrivalinfoapp.data.entity.SubwayInfoEntity
import com.hegunhee.subwayarrivalinfoapp.db.SubwayInfoDao
import kotlinx.coroutines.flow.Flow

class DefaultRepository(private val subwayInfoDao: SubwayInfoDao) : Repository{
    override suspend fun insertSubwayInfoList(infoList: List<SubwayInfoEntity>) {
        subwayInfoDao.insertSubwayInfoList(infoList)
    }

    override suspend fun toggleSubwayInfo(subwayInfoEntity: SubwayInfoEntity) {
        subwayInfoDao.toggleSubwayInfo(subwayInfoEntity)
    }

    override fun getAllSubwayInfoListByFlow(): Flow<List<SubwayInfoEntity>> {
        return subwayInfoDao.getAllSubwayInfoByFlow()
    }
}