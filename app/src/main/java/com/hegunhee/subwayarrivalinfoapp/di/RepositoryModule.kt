package com.hegunhee.subwayarrivalinfoapp.di

import com.hegunhee.subwayarrivalinfoapp.db.SubwayInfoDao
import com.hegunhee.subwayarrivalinfoapp.model.DefaultRepository
import com.hegunhee.subwayarrivalinfoapp.model.Repository
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
        subwayInfoDao: SubwayInfoDao
    ) : Repository {
        return DefaultRepository(subwayInfoDao)
    }
}