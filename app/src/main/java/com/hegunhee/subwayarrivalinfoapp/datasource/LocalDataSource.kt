package com.hegunhee.subwayarrivalinfoapp.datasource

import com.hegunhee.subwayarrivalinfoapp.data.entity.Favorites
import com.hegunhee.subwayarrivalinfoapp.data.entity.SubwayInfoEntity
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    suspend fun insertSubwayInfoList(infoList : List<SubwayInfoEntity>)

    suspend fun updateSubwayInfoBookMark(subwayInfoEntity: SubwayInfoEntity)

    fun getAllSubwayInfoListByFlow() : Flow<List<SubwayInfoEntity>>

    suspend fun getSubwayInfoByNameOrNull(stationName : String) : SubwayInfoEntity?

    suspend fun getFavoritesList() : List<Favorites>

    suspend fun insertFavorite(favorites : Favorites)

    suspend fun deleteFavorite(stationInfo : String)

    fun getFavoritesListByFlow() : Flow<List<Favorites>>
}