package com.hegunhee.subwayarrivalinfoapp.domain

import android.util.Log
import com.hegunhee.subwayarrivalinfoapp.data.json.subway_arrival.SubwayArrivalSmallDataWithStationLine
import com.hegunhee.subwayarrivalinfoapp.model.Repository
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

@InstallIn(SingletonComponent::class)
@Module
class GetSortedSubwayArrivalListUseCase @Inject constructor(
    private val repository: Repository,
    private val getSubwayArrivalListUseCase: GetSubwayArrivalListUseCase,
) {

    suspend operator fun invoke(station_name : String) : List<SubwayArrivalSmallDataWithStationLine>{
        val thisStation = repository.getSubwayInfoByName(station_name) ?: return listOf()
        var subwayList = listOf<SubwayArrivalSmallDataWithStationLine>()
        val favoriteList = repository.getFavoritesList()
        getSubwayArrivalListUseCase(station_name).forEach {
            val nextStation = repository.getSubwayInfoByName(it.nextStation) ?: return@forEach
            val list = nextStation.subwayLine + thisStation.subwayLine
            val station_line= list.groupBy { it }.filter { it.value.size > 1 }.flatMap { it.value }.distinct()
            if(station_line.isNotEmpty()){
                val isFavorite = favoriteList.filter { favoriteList -> favoriteList.subway_info == it.fullName }.isNotEmpty()
                subwayList += it.toWithStationLine(station_line.first(),isFavorite)
            }
        }
        Log.d("ArrivalTest",subwayList.toString())
        return subwayList
    }

}