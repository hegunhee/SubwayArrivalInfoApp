package com.hegunhee.subwayarrivalinfoapp.domain

import android.util.Log
import com.hegunhee.subwayarrivalinfoapp.data.json.subway_arrival.SubwayArrivalSmallData
import com.hegunhee.subwayarrivalinfoapp.model.Repository
import com.hegunhee.subwayarrivalinfoapp.network.SubwayArrivalApi
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.awaitResponse
import javax.inject.Inject

@InstallIn(SingletonComponent::class)
@Module
class GetSubwayArrivalListUseCase @Inject constructor(
    private val repository: Repository
) : UseCase{

    suspend operator fun invoke(station_name : String) : List<SubwayArrivalSmallData>{
        var list = listOf<SubwayArrivalSmallData>()
        repository.getAllSubwayArrivalList(station_name).awaitResponse().body()?.let {
            list = it.realtimeArrivalList.map { it.toSmallData() }
        }
        return list
    }
}