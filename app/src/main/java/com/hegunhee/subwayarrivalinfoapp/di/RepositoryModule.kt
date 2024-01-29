package com.hegunhee.subwayarrivalinfoapp.di

import com.hegunhee.subwayarrivalinfoapp.domain.repository.DefaultRepository
import com.hegunhee.subwayarrivalinfoapp.domain.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun provideDefaultRepository(
        defaultRepository: DefaultRepository
    ) : Repository
}