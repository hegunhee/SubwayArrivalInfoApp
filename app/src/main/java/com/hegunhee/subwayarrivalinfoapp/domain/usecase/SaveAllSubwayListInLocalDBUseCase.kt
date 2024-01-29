package com.hegunhee.subwayarrivalinfoapp.domain.usecase

import com.hegunhee.subwayarrivalinfoapp.domain.repository.Repository
import javax.inject.Inject

class SaveAllSubwayListInLocalDBUseCase @Inject constructor(private val repository: Repository){

    suspend operator fun invoke() : Result<Boolean>{
        return repository.saveAllSubwayListInLocalDB()
    }
}