package com.hegunhee.subwayarrivalinfoapp.domain.usecase

import com.hegunhee.subwayarrivalinfoapp.data.entity.Favorites
import com.hegunhee.subwayarrivalinfoapp.data.json.subway_arrival.SubwayArrivalSmallDataWithFavorite
import com.hegunhee.subwayarrivalinfoapp.domain.repository.Repository
import javax.inject.Inject

class GetFavoriteSubwayInfoUseCase @Inject constructor(private val repository : Repository) {
    suspend operator fun invoke(favorite : Favorites) : Result<List<SubwayArrivalSmallDataWithFavorite>>{
        return repository.getFavoriteSubwayInfoList(favorite)
    }
}