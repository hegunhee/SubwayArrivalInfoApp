package com.hegunhee.subwayarrivalinfoapp.domain

import com.hegunhee.subwayarrivalinfoapp.data.entity.SubwayInfoEntity
import com.hegunhee.subwayarrivalinfoapp.model.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllSubwayInfoListByFlowUseCase @Inject constructor(
    private val repository: Repository
) : UseCase {

    operator fun invoke() : Flow<List<SubwayInfoEntity>>{
        return repository.getAllSubwayInfoListByFlow()
    }
}