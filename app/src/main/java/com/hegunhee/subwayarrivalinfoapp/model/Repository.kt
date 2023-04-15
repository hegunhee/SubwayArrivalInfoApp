package com.hegunhee.subwayarrivalinfoapp.model

import com.hegunhee.subwayarrivalinfoapp.data.entity.Favorites
import com.hegunhee.subwayarrivalinfoapp.data.entity.SubwayInfoEntity
import com.hegunhee.subwayarrivalinfoapp.data.json.subway_arrival.SubwayArrivalJson
import com.hegunhee.subwayarrivalinfoapp.data.json.subway_info.JsonSubwayInfo
import kotlinx.coroutines.flow.Flow

interface Repository {

    suspend fun insertSubwayInfoList(infoList : List<SubwayInfoEntity>)

    suspend fun toggleSubwayInfoBookMarked(subwayInfoEntity: SubwayInfoEntity)

    fun getAllSubwayInfoListByFlow() : Flow<List<SubwayInfoEntity>>

    suspend fun fetchAllSubwayList()

    suspend fun getAllSubwayList() : Result<JsonSubwayInfo>

    suspend fun getAllSubwayArrivalList(station_name : String) : Result<List<SubwayArrivalSmallDataWithFavorite>>

    suspend fun getSubwayInfoByName(station_name : String) : SubwayInfoEntity?

    suspend fun getFavoritesList() : List<Favorites>

    suspend fun insertFavorite(favorites: Favorites)

    suspend fun deleteFavorite(station_info : String)

    fun getFavoritesListByFlow() : Flow<List<Favorites>>
}