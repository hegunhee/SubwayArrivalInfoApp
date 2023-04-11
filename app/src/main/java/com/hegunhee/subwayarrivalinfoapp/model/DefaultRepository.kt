package com.hegunhee.subwayarrivalinfoapp.model

import android.util.Log
import com.hegunhee.subwayarrivalinfoapp.Util.subway_line_limit
import com.hegunhee.subwayarrivalinfoapp.data.entity.Favorites
import com.hegunhee.subwayarrivalinfoapp.data.entity.SubwayInfoEntity
import com.hegunhee.subwayarrivalinfoapp.data.json.subway_arrival.SubwayArrivalJson
import com.hegunhee.subwayarrivalinfoapp.data.json.subway_info.JsonSubwayInfo
import com.hegunhee.subwayarrivalinfoapp.db.FavoritesDao
import com.hegunhee.subwayarrivalinfoapp.db.SubwayInfoDao
import com.hegunhee.subwayarrivalinfoapp.network.SubwayArrivalApi
import com.hegunhee.subwayarrivalinfoapp.network.SubwayInfoApi
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DefaultRepository @Inject constructor(
    private val subwayInfoDao: SubwayInfoDao,
    private val subwayInfoApi : SubwayInfoApi,
    private val subwayArrivalApi: SubwayArrivalApi,
    private val favoritesDao: FavoritesDao
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

    override suspend fun insertAllSubwayList() {
        getAllSubwayList()
            .onSuccess {info ->
                info.searchInfoBySubwayNameService.let { subwayInfo ->
                    if(subwayInfo.result.isSuccess()){
                        val subwayInfoList = subwayInfo.row.filter { it.line_num.substring(1) in subway_line_limit }.groupBy { it.station_nm }.map { subway ->
                            SubwayInfoEntity(subway.key,subway.value.map { it.line_num.substring(1) })
                        }.toList()
                        subwayInfoDao.insertSubwayInfoList(subwayInfoList)
                    }
                }
            }
            .onFailure {

            }
    }

    override suspend fun getAllSubwayList(): Result<JsonSubwayInfo> {
        return runCatching { subwayInfoApi.getSubwayInfo() }
    }

    override suspend fun getAllSubwayArrivalList(stationName : String): SubwayArrivalJson {
        return subwayArrivalApi.getSubwayInfo(station_nm =stationName )
    }

    override suspend fun getSubwayInfoByName(station_name: String): SubwayInfoEntity? {
        return subwayInfoDao.getSubwayInfoByName(station_name)
    }

    override suspend fun getFavoritesList(): List<Favorites> {
        return favoritesDao.getFavoritesList()
    }

    override suspend fun insertFavorite(favorites: Favorites) {
        favoritesDao.insertFavorites(favorites)
    }

    override suspend fun deleteFavorite(station_info: String) {
        favoritesDao.deleteFavorites(station_info)
    }

    override fun getFavoritesListByFlow(): Flow<List<Favorites>> {
        return favoritesDao.getFavoritesListByFlow()
    }
}