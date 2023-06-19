package com.hegunhee.subwayarrivalinfoapp.model

import com.hegunhee.subwayarrivalinfoapp.Util.subway_line_limit
import com.hegunhee.subwayarrivalinfoapp.data.entity.Favorites
import com.hegunhee.subwayarrivalinfoapp.data.entity.SubwayInfoEntity
import com.hegunhee.subwayarrivalinfoapp.data.json.subway_arrival.SubwayArrivalSmallDataWithFavorite
import com.hegunhee.subwayarrivalinfoapp.data.json.subway_info.JsonSubwayInfo
import com.hegunhee.subwayarrivalinfoapp.datasource.LocalDataSource
import com.hegunhee.subwayarrivalinfoapp.db.FavoritesDao
import com.hegunhee.subwayarrivalinfoapp.network.SubwayArrivalApi
import com.hegunhee.subwayarrivalinfoapp.network.SubwayInfoApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DefaultRepository @Inject constructor(
    private val subwayInfoApi : SubwayInfoApi,
    private val subwayArrivalApi: SubwayArrivalApi,
    private val localDataSource: LocalDataSource
    ) : Repository{
    override suspend fun insertSubwayInfoList(infoList: List<SubwayInfoEntity>) {
        localDataSource.insertSubwayInfoList(infoList)
    }

    override suspend fun updateSubwayInfoBookMark(subwayInfoEntity: SubwayInfoEntity) {
        localDataSource.updateSubwayInfoBookMark(subwayInfoEntity)
    }

    override fun getAllSubwayInfoListByFlow(): Flow<List<SubwayInfoEntity>> {
        return localDataSource.getAllSubwayInfoListByFlow()
    }

    override suspend fun fetchAllSubwayList() {
        getAllSubwayList()
            .onSuccess {info ->
                info.searchInfoBySubwayNameService.let { subwayInfo ->
                    if(subwayInfo.result.isSuccess()){
                        val subwayInfoList = subwayInfo.row.filter { it.getFormattedLineNum() in subway_line_limit }.groupBy { it.station_nm }.map { subway ->
                            SubwayInfoEntity(subway.key,subway.value.map { it.getFormattedLineNum() })
                        }.toList()
                        localDataSource.insertSubwayInfoList(subwayInfoList)
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
                val isFavorite = favoriteList.any{favorites -> favorites.subwayInfo == subwayArrivalSmallData.subwayInfo}
                subwayArrivalSmallData.toSubwayArrivalSmallDataWithFavorite(isFavorite)
            }.toList()
        }
    }

    override suspend fun getSubwayInfoByNameOrNull(stationName: String): SubwayInfoEntity? {
        return localDataSource.getSubwayInfoByNameOrNull(stationName)
    }

    override suspend fun getFavoritesList(): List<Favorites> {
        return localDataSource.getFavoritesList() }

    override suspend fun insertFavorite(favorites: Favorites) {
        localDataSource.insertFavorite(favorites)
    }

    override suspend fun getFavoriteSubwayInfoList(favorite: Favorites): Result<List<SubwayArrivalSmallDataWithFavorite>> {
        return getAllSubwayArrivalList(favorite.subwayName).map { subwayArrivalSmallData ->
            subwayArrivalSmallData.filter { it.fullName == favorite.subwayInfo }
        }
    }

    override suspend fun deleteFavorite(stationInfo: String) {
        localDataSource.deleteFavorite(stationInfo)
    }

    override fun getFavoritesListByFlow(): Flow<List<Favorites>> {
        return localDataSource.getFavoritesListByFlow()
    }
}