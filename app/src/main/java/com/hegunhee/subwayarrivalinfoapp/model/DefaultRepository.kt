package com.hegunhee.subwayarrivalinfoapp.model

import com.hegunhee.subwayarrivalinfoapp.BuildConfig
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

class DefaultRepository(
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

    override suspend fun getAllSubwayList(): Call<JsonSubwayInfo> {
        return subwayInfoApi.getSubwayInfo(BuildConfig.SUBWAY_INFO_API_KEY)
    }

    override suspend fun getAllSubwayArrivalList(stationName : String): Call<SubwayArrivalJson> {
        return subwayArrivalApi.getSubwayInfo(key = BuildConfig.SUBWAY_ARRIVAL_API_KEY, station_nm =stationName )
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