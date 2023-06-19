package com.hegunhee.subwayarrivalinfoapp.domain

import com.hegunhee.subwayarrivalinfoapp.model.Repository
import javax.inject.Inject

class SaveAllSubwayListInLocalDBUseCase @Inject constructor(private val repository: Repository){

    suspend operator fun invoke() : Result<Boolean>{
        return repository.saveAllSubwayListInLocalDB()
    }
}