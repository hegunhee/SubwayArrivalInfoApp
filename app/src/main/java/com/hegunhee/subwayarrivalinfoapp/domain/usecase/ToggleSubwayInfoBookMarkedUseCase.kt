package com.hegunhee.subwayarrivalinfoapp.domain.usecase

import com.hegunhee.subwayarrivalinfoapp.data.entity.SubwayInfoEntity
import com.hegunhee.subwayarrivalinfoapp.domain.repository.Repository
import javax.inject.Inject

class ToggleSubwayInfoBookMarkedUseCase @Inject constructor(private val repository: Repository){

    suspend operator fun invoke(subwayInfoEntity: SubwayInfoEntity) {
        repository.updateSubwayInfoBookMark(subwayInfoEntity)
    }
}