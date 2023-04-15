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

    override suspend fun toggleSubwayInfoBookMarked(subwayInfoEntity: SubwayInfoEntity) {
        subwayInfoDao.toggleSubwayInfoBookMarked(subwayInfoEntity)
    }

    override fun getAllSubwayInfoListByFlow(): Flow<List<SubwayInfoEntity>> {
        return subwayInfoDao.getAllSubwayInfoByFlow()
    }

    override suspend fun fetchAllSubwayList() {
        getAllSubwayList()
            .onSuccess {info ->
                info.searchInfoBySubwayNameService.let { subwayInfo ->
                    if(subwayInfo.result.isSuccess()){
                        val subwayInfoList = subwayInfo.row.filter { it.getFormattedLineNum() in subway_line_limit }.groupBy { it.station_nm }.map { subway ->
                            SubwayInfoEntity(subway.key,subway.value.map { it.getFormattedLineNum() })
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

    override suspend fun getAllSubwayArrivalList(stationName : String): Result<List<SubwayArrivalSmallDataWithFavorite>> {
        val favoriteList = getFavoritesList()
        return runCatching {
            val subwayArrivalData = subwayArrivalApi.getSubwayInfo(stationName = stationName).realtimeArrivalList.map { it.toSmallData() }
            subwayArrivalData.map { subwayArrivalSmallData ->
                val isFavorite = favoriteList.any{favorites -> favorites.subway_info == subwayArrivalSmallData.subwayInfo}
                subwayArrivalSmallData.toSubwayArrivalSmallDataWithFavorite(isFavorite)
            }.toList()
        }
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