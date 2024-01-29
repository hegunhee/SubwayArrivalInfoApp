package com.hegunhee.subwayarrivalinfoapp.domain.usecase

import com.hegunhee.subwayarrivalinfoapp.data.entity.Favorites
import com.hegunhee.subwayarrivalinfoapp.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFavoritesListByFlowUseCase @Inject constructor(private val repository: Repository){
    operator fun invoke()  : Flow<List<Favorites>>{
        return repository.getFavoritesListByFlow()
    }
}