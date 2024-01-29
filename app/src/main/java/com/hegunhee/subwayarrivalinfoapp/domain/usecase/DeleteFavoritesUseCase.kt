package com.hegunhee.subwayarrivalinfoapp.domain.usecase

import com.hegunhee.subwayarrivalinfoapp.domain.repository.Repository
import javax.inject.Inject

class DeleteFavoritesUseCase @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke(stationInfo: String) {
        repository.deleteFavorite(stationInfo)
    }
}