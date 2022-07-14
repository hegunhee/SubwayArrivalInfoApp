package com.hegunhee.subwayarrivalinfoapp.domain

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

    suspend operator fun invoke(station_name : String){
        // 역에대한 정보를 가져와야됨
        // 가져오고 null인지 아닌지 체크
        //
//        getSubwayArrivalListUseCase(station_name).filter { repository.getSubwayInfoByName(it.nextStation) != null }.
//                filter { repository.getSubwayInfoByName(it.nextStation)}
    }

}