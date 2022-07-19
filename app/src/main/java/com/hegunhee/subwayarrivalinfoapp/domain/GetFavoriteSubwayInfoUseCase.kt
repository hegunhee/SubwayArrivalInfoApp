package com.hegunhee.subwayarrivalinfoapp.domain

import com.hegunhee.subwayarrivalinfoapp.data.entity.Favorites
import com.hegunhee.subwayarrivalinfoapp.data.json.subway_arrival.SubwayArrivalSmallDataWithStationLine
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

@InstallIn(SingletonComponent::class)
@Module
class GetFavoriteSubwayInfoUseCase @Inject constructor(
    private val getSortedSubwayArrivalListUseCase: GetSortedSubwayArrivalListUseCase,
){
    suspend operator fun invoke(subwayInfo : Favorites) : List<SubwayArrivalSmallDataWithStationLine>{
        return getSortedSubwayArrivalListUseCase(subwayInfo.subway_name).let {
            it.filter { it.fullName == subwayInfo.subway_info }
        }
    }
}