package com.hegunhee.subwayarrivalinfoapp.di

import com.hegunhee.subwayarrivalinfoapp.datasource.DefaultLocalDataSource
import com.hegunhee.subwayarrivalinfoapp.datasource.LocalDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class DataSourceModule {

    @Binds
    @Singleton
    abstract fun provideLocalDataSource(defaultLocalDataSource: DefaultLocalDataSource) : LocalDataSource
}