package com.hegunhee.subwayarrivalinfoapp.domain

import com.hegunhee.subwayarrivalinfoapp.model.Repository
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

@InstallIn(SingletonComponent::class)
@Module
class InsertSubwayInfoListUseCase @Inject constructor(
    private val repository: Repository
) : UseCase {
    suspend operator fun invoke(){
        repository.insertAllSubwayList()
    }
}