package com.hegunhee.subwayarrivalinfoapp.di

import com.hegunhee.subwayarrivalinfoapp.db.FavoritesDao
import com.hegunhee.subwayarrivalinfoapp.db.SubwayInfoDao
import com.hegunhee.subwayarrivalinfoapp.model.DefaultRepository
import com.hegunhee.subwayarrivalinfoapp.model.Repository
import com.hegunhee.subwayarrivalinfoapp.network.SubwayArrivalApi
import com.hegunhee.subwayarrivalinfoapp.network.SubwayInfoApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideDefaultRepository(
        subwayInfoDao: SubwayInfoDao,
        subwayInfoApi: SubwayInfoApi,
        subwayArrivalApi: SubwayArrivalApi,
        favoritesDao: FavoritesDao
    ) : Repository {
        return DefaultRepository(subwayInfoDao,subwayInfoApi,subwayArrivalApi,favoritesDao)
    }
}