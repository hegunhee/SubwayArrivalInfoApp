package com.hegunhee.subwayarrivalinfoapp.domain

import android.util.Log
import com.hegunhee.subwayarrivalinfoapp.data.json.subway_arrival.SubwayArrivalSmallDataWithFavorite
import com.hegunhee.subwayarrivalinfoapp.model.Repository
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

@InstallIn(SingletonComponent::class)
@Module
class GetSortedSubwayArrivalListUseCase @Inject constructor(
    private val repository: Repository,
) {

    suspend operator fun invoke(station_name : String) : Result<List<SubwayArrivalSmallDataWithFavorite>>{
        return repository.getAllSubwayArrivalList(station_name)
    }

}