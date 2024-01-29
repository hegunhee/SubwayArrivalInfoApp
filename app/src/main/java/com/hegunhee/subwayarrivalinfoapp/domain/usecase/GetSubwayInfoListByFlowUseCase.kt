package com.hegunhee.subwayarrivalinfoapp.domain.usecase

import com.hegunhee.subwayarrivalinfoapp.data.entity.SubwayInfoEntity
import com.hegunhee.subwayarrivalinfoapp.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSubwayInfoListByFlowUseCase @Inject constructor(private val repository: Repository){

    operator fun invoke() : Flow<List<SubwayInfoEntity>>{
        return repository.getAllSubwayInfoListByFlow()
    }
}