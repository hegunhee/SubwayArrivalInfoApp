package com.hegunhee.subwayarrivalinfoapp.model

import com.hegunhee.subwayarrivalinfoapp.BuildConfig
import com.hegunhee.subwayarrivalinfoapp.data.entity.SubwayInfoEntity
import com.hegunhee.subwayarrivalinfoapp.data.json.subway_info.JsonSubwayInfo
import com.hegunhee.subwayarrivalinfoapp.db.SubwayInfoDao
import com.hegunhee.subwayarrivalinfoapp.network.SubwayInfoApi
import kotlinx.coroutines.flow.Flow
import retrofit2.Call

class DefaultRepository(
    private val subwayInfoDao: SubwayInfoDao,
    private val subwayInfoApi : SubwayInfoApi
    ) : Repository{
    override suspend fun insertSubwayInfoList(infoList: List<SubwayInfoEntity>) {
        subwayInfoDao.insertSubwayInfoList(infoList)
    }

    override suspend fun toggleSubwayInfo(subwayInfoEntity: SubwayInfoEntity) {
        subwayInfoDao.toggleSubwayInfo(subwayInfoEntity)
    }

    override fun getAllSubwayInfoListByFlow(): Flow<List<SubwayInfoEntity>> {
        return subwayInfoDao.getAllSubwayInfoByFlow()
    }

    override suspend fun getAllSubwayList(): Call<JsonSubwayInfo> {
        return subwayInfoApi.getSubwayInfo(BuildConfig.SUBWAY_INFO_API_KEY)
    }
}