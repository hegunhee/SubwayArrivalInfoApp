package com.hegunhee.subwayarrivalinfoapp.model

import com.hegunhee.subwayarrivalinfoapp.data.entity.Favorites
import com.hegunhee.subwayarrivalinfoapp.data.entity.SubwayInfoEntity
import com.hegunhee.subwayarrivalinfoapp.data.json.subway_arrival.SubwayArrivalSmallDataWithFavorite
import com.hegunhee.subwayarrivalinfoapp.data.toSubwayInfoEntityList
import com.hegunhee.subwayarrivalinfoapp.datasource.LocalDataSource
import com.hegunhee.subwayarrivalinfoapp.datasource.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DefaultRepository @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource : RemoteDataSource
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

    override suspend fun getSubwayInfoByNameOrNull(stationName: String): SubwayInfoEntity? {
        return localDataSource.getSubwayInfoByNameOrNull(stationName)
    }

    override suspend fun insertFavorite(favorites: Favorites) {
        localDataSource.insertFavorite(favorites)
    }

    override suspend fun deleteFavorite(stationInfo: String) {
        localDataSource.deleteFavorite(stationInfo)
    }

    override fun getFavoritesListByFlow(): Flow<List<Favorites>> {
        return localDataSource.getFavoritesListByFlow()
    }

    override suspend fun saveAllSubwayListInLocalDB() : Result<Boolean> {
        return runCatching {
            val subwayInfo = remoteDataSource.getAllSubwayList().searchInfoBySubwayNameService
            if(subwayInfo.result.isSuccess()){
                localDataSource.insertSubwayInfoList(subwayInfo.toSubwayInfoEntityList())
            }
            return@runCatching subwayInfo.result.isSuccess()
        }
    }

    override suspend fun getAllSubwayArrivalList(stationName : String): Result<List<SubwayArrivalSmallDataWithFavorite>> {
        val favoriteList = localDataSource.getFavoritesList()
        return runCatching {
            val subwayArrivalData = remoteDataSource.getSubwayInfo(stationName = stationName).realtimeArrivalList.map { it.toSmallData() }
            subwayArrivalData.map { subwayArrivalSmallData ->
                val isFavorite = favoriteList.any{favorites -> favorites.subwayInfo == subwayArrivalSmallData.subwayInfo}
                subwayArrivalSmallData.toSubwayArrivalSmallDataWithFavorite(isFavorite)
            }.toList()
        }
    }

    override suspend fun getFavoriteSubwayInfoList(favorite: Favorites): Result<List<SubwayArrivalSmallDataWithFavorite>> {
        return getAllSubwayArrivalList(favorite.subwayName).map { subwayArrivalSmallData ->
            subwayArrivalSmallData.filter { it.fullName == favorite.subwayInfo }
        }
    }
}