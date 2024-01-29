package com.hegunhee.subwayarrivalinfoapp.domain.repository

import com.hegunhee.subwayarrivalinfoapp.data.entity.Favorites
import com.hegunhee.subwayarrivalinfoapp.data.entity.SubwayInfoEntity
import com.hegunhee.subwayarrivalinfoapp.model.SubwayArrivalInfo
import kotlinx.coroutines.flow.Flow

interface Repository {

    suspend fun insertSubwayInfoList(infoList : List<SubwayInfoEntity>)

    suspend fun updateSubwayInfoBookMark(subwayInfoEntity: SubwayInfoEntity)

    fun getAllSubwayInfoListByFlow() : Flow<List<SubwayInfoEntity>>


    suspend fun saveAllSubwayListInLocalDB() : Result<Boolean>
  
    suspend fun getAllSubwayArrivalList(stationName : String) : Result<List<SubwayArrivalInfo>>

    suspend fun getSubwayInfoByNameOrNull(stationName : String) : SubwayInfoEntity?

    suspend fun insertFavorite(favorites: Favorites)

    suspend fun getFavoriteSubwayInfoList(favorite : Favorites) : Result<List<SubwayArrivalInfo>>

    suspend fun deleteFavorite(stationInfo : String)

    fun getFavoritesListByFlow() : Flow<List<Favorites>>
}