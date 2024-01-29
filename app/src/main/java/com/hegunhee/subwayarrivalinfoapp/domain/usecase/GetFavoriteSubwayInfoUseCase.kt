package com.hegunhee.subwayarrivalinfoapp.domain.usecase

import com.hegunhee.subwayarrivalinfoapp.data.entity.Favorites
import com.hegunhee.subwayarrivalinfoapp.model.SubwayArrivalInfo
import com.hegunhee.subwayarrivalinfoapp.domain.repository.Repository
import javax.inject.Inject

class GetFavoriteSubwayInfoUseCase @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke(favorite: Favorites): Result<List<SubwayArrivalInfo>> {
        return repository.getFavoriteSubwayInfoList(favorite)
    }
}