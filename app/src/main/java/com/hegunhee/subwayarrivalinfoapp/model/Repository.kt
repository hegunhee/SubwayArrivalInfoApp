package com.hegunhee.subwayarrivalinfoapp.model

import com.hegunhee.subwayarrivalinfoapp.data.entity.Favorites
import com.hegunhee.subwayarrivalinfoapp.data.entity.SubwayInfoEntity
import com.hegunhee.subwayarrivalinfoapp.data.json.subway_arrival.SubwayArrivalJson
import com.hegunhee.subwayarrivalinfoapp.data.json.subway_arrival.SubwayArrivalSmallDataWithFavorite
import com.hegunhee.subwayarrivalinfoapp.data.json.subway_info.JsonSubwayInfo
import kotlinx.coroutines.flow.Flow

interface Repository {

    suspend fun insertSubwayInfoList(infoList : List<SubwayInfoEntity>)

    suspend fun updateSubwayInfoBookMark(subwayInfoEntity: SubwayInfoEntity)

    fun getAllSubwayInfoListByFlow() : Flow<List<SubwayInfoEntity>>

    suspend fun fetchAllSubwayList()

    suspend fun getAllSubwayArrivalList(station_name : String) : Result<List<SubwayArrivalSmallDataWithFavorite>>

    suspend fun getSubwayInfoByNameOrNull(station_name : String) : SubwayInfoEntity?

    suspend fun insertFavorite(favorites: Favorites)

    suspend fun getFavoriteSubwayInfoList(favorite : Favorites) : Result<List<SubwayArrivalSmallDataWithFavorite>>

    suspend fun deleteFavorite(station_info : String)

    fun getFavoritesListByFlow() : Flow<List<Favorites>>
}