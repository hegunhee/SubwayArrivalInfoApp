package com.hegunhee.subwayarrivalinfoapp.di

import com.google.gson.Gson
import com.hegunhee.subwayarrivalinfoapp.network.SUBWAY_ARRIVAL_BASE_URL
import com.hegunhee.subwayarrivalinfoapp.network.SUBWAY_INFO_BASE_URL
import com.hegunhee.subwayarrivalinfoapp.network.SubwayArrivalApi
import com.hegunhee.subwayarrivalinfoapp.network.SubwayInfoApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {


    @Singleton
    @Provides
    fun provideMoshi() : Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    @Singleton
    @Provides
    fun provideSubwayInfoApi(
        moshi : Moshi
    ) : SubwayInfoApi{
        return Retrofit.Builder()
            .baseUrl(SUBWAY_INFO_BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(SubwayInfoApi::class.java)
    }

    @Singleton
    @Provides
    fun provideSubwayArrivalApi(moshi : Moshi) : SubwayArrivalApi{
        return Retrofit.Builder()
            .baseUrl(SUBWAY_ARRIVAL_BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(SubwayArrivalApi::class.java)
    }
}