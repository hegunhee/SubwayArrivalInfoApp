package com.hegunhee.subwayarrivalinfoapp.domain

import com.hegunhee.subwayarrivalinfoapp.data.entity.Favorites
import com.hegunhee.subwayarrivalinfoapp.model.Repository
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

@InstallIn(SingletonComponent::class)
@Module
class InsertFavoritesUseCase @Inject constructor(private val repository: Repository) {

    suspend operator fun invoke(favorites: Favorites){
        repository.insertFavorite(favorites)
    }
}