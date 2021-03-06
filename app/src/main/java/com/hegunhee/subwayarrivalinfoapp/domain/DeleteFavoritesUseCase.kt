package com.hegunhee.subwayarrivalinfoapp.domain

import com.hegunhee.subwayarrivalinfoapp.model.Repository
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

@InstallIn(SingletonComponent::class)
@Module
class DeleteFavoritesUseCase @Inject constructor(
    private val repository: Repository
): UseCase {

    suspend operator fun invoke(station_info : String){
        repository.deleteFavorite(station_info)
    }
}