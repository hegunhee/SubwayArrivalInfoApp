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
    private val getSubwayArrivalListUseCase: GetSubwayArrivalListUseCase
) {

    suspend operator fun invoke(station_name : String) : List<SubwayArrivalSmallDataWithStationLine>{
        // 역에대한 정보를 가져와야됨
        // 가져오고 null인지 아닌지 체크
        //
        val thisStation = repository.getSubwayInfoByName(station_name) ?: return listOf()
        var subwayList = listOf<SubwayArrivalSmallDataWithStationLine>()
        getSubwayArrivalListUseCase(station_name).forEach {
            val nextStation = repository.getSubwayInfoByName(it.nextStation) ?: return@forEach
            val list = nextStation.subwayLine + thisStation.subwayLine
            val station_line= list.groupBy { it }.filter { it.value.size > 1 }.flatMap { it.value }.distinct()
            if(station_line.isNotEmpty()){
                subwayList += it.toWithStationLine(station_line.first())
            }

        }
        Log.d("ArrivalTest",subwayList.toString())
//        getSubwayArrivalListUseCase(station_name).filter { repository.getSubwayInfoByName(it.nextStation) != null }.
//                filter { repository.getSubwayInfoByName(it.nextStation)}
        return subwayList
    }

}