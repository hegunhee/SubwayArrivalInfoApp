package com.hegunhee.subwayarrivalinfoapp.domain

import com.hegunhee.subwayarrivalinfoapp.data.entity.SubwayInfoEntity
import com.hegunhee.subwayarrivalinfoapp.model.Repository
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@InstallIn(SingletonComponent::class)
@Module
class GetAllSubwayInfoListByFlowUseCase @Inject constructor(
    private val repository: Repository
) : UseCase {

    operator fun invoke() : Flow<List<SubwayInfoEntity>>{
        return repository.getAllSubwayInfoListByFlow()
    }
}