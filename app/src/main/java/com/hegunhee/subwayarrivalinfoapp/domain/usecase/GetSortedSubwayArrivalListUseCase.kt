package com.hegunhee.subwayarrivalinfoapp.domain.usecase

import com.hegunhee.subwayarrivalinfoapp.model.SubwayArrivalInfo
import com.hegunhee.subwayarrivalinfoapp.domain.repository.Repository
import javax.inject.Inject


class GetSortedSubwayArrivalListUseCase @Inject constructor(private val repository: Repository) {

    suspend operator fun invoke(stationName: String): Result<List<SubwayArrivalInfo>> {
        return repository.getAllSubwayArrivalList(stationName)
    }

}