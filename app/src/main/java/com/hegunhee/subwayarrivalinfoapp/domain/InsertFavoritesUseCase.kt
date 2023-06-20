package com.hegunhee.subwayarrivalinfoapp.domain

import com.hegunhee.subwayarrivalinfoapp.data.entity.Favorites
import com.hegunhee.subwayarrivalinfoapp.model.Repository
import javax.inject.Inject

class InsertFavoritesUseCase @Inject constructor(private val repository: Repository) {

    suspend operator fun invoke(favorites: Favorites){
        repository.insertFavorite(favorites)
    }
}