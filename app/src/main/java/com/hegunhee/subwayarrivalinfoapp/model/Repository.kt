package com.hegunhee.subwayarrivalinfoapp.model

import com.hegunhee.subwayarrivalinfoapp.data.entity.Favorites
import com.hegunhee.subwayarrivalinfoapp.data.entity.SubwayInfoEntity
import com.hegunhee.subwayarrivalinfoapp.data.json.subway_arrival.SubwayArrivalSmallDataWithFavorite
import kotlinx.coroutines.flow.Flow

interface Repository {

    suspend fun insertSubwayInfoList(infoList : List<SubwayInfoEntity>)

    suspend fun updateSubwayInfoBookMark(subwayInfoEntity: SubwayInfoEntity)

    fun getAllSubwayInfoListByFlow() : Flow<List<SubwayInfoEntity>>


    suspend fun saveAllSubwayListInLocalDB() : Result<Boolean>
  
    suspend fun getAllSubwayArrivalList(stationName : String) : Result<List<SubwayArrivalSmallDataWithFavorite>>

    suspend fun getSubwayInfoByNameOrNull(stationName : String) : SubwayInfoEntity?

    suspend fun insertFavorite(favorites: Favorites)

    suspend fun getFavoriteSubwayInfoList(favorite : Favorites) : Result<List<SubwayArrivalSmallDataWithFavorite>>

    suspend fun deleteFavorite(stationInfo : String)

    fun getFavoritesListByFlow() : Flow<List<Favorites>>
}