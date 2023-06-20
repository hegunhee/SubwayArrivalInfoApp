package com.hegunhee.subwayarrivalinfoapp.domain

import com.hegunhee.subwayarrivalinfoapp.model.Repository
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

class DeleteFavoritesUseCase @Inject constructor(private val repository: Repository){
    suspend operator fun invoke(stationInfo : String){
        repository.deleteFavorite(stationInfo)
    }
}