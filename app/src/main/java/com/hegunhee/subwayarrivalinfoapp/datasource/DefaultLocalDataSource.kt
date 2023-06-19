package com.hegunhee.subwayarrivalinfoapp.datasource

import com.hegunhee.subwayarrivalinfoapp.data.entity.Favorites
import com.hegunhee.subwayarrivalinfoapp.data.entity.SubwayInfoEntity
import com.hegunhee.subwayarrivalinfoapp.db.FavoritesDao
import com.hegunhee.subwayarrivalinfoapp.db.SubwayInfoDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DefaultLocalDataSource @Inject constructor(
    private val subwayInfoDao : SubwayInfoDao,
    private val favoritesDao : FavoritesDao
) : LocalDataSource {
    override suspend fun insertSubwayInfoList(infoList : List<SubwayInfoEntity>) {
       subwayInfoDao.insertSubwayInfoList(infoList)
    }

    override suspend fun updateSubwayInfoBookMark(subwayInfoEntity: SubwayInfoEntity) {
        subwayInfoDao.toggleSubwayInfoBookMarked(subwayInfoEntity)
    }

    override fun getAllSubwayInfoListByFlow(): Flow<List<SubwayInfoEntity>> {
        return subwayInfoDao.getAllSubwayInfoByFlow()
    }

    override suspend fun getSubwayInfoByNameOrNull(stationName: String): SubwayInfoEntity? {
        return subwayInfoDao.getSubwayInfoByName(stationName)
    }

    override suspend fun getFavoritesList(): List<Favorites> {
        return favoritesDao.getFavoritesList()
    }

    override suspend fun insertFavorite(favorites: Favorites) {
        favoritesDao.insertFavorites(favorites)
    }

    override suspend fun deleteFavorite(stationInfo: String) {
        favoritesDao.deleteFavorites(stationInfo)
    }

    override suspend fun getFavoritesListByFlow(): Flow<List<Favorites>> {
        return favoritesDao.getFavoritesListByFlow()
    }
}