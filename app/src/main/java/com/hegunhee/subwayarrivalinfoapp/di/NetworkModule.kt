package com.hegunhee.subwayarrivalinfoapp.di

import com.google.gson.Gson
import com.hegunhee.subwayarrivalinfoapp.network.SUBWAY_ARRIVAL_BASE_URL
import com.hegunhee.subwayarrivalinfoapp.network.SUBWAY_INFO_BASE_URL
import com.hegunhee.subwayarrivalinfoapp.network.SubwayArrivalApi
import com.hegunhee.subwayarrivalinfoapp.network.SubwayInfoApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideSubwayInfoApi() : SubwayInfoApi{
        return Retrofit.Builder()
            .baseUrl(SUBWAY_INFO_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SubwayInfoApi::class.java)
    }

    @Singleton
    @Provides
    fun provideSubwayArrivalApi() : SubwayArrivalApi{
        return Retrofit.Builder()
            .baseUrl(SUBWAY_ARRIVAL_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SubwayArrivalApi::class.java)
    }
}