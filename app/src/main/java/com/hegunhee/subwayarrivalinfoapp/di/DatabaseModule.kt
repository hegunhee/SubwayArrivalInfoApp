package com.hegunhee.subwayarrivalinfoapp.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hegunhee.subwayarrivalinfoapp.db.FavoritesDao
import com.hegunhee.subwayarrivalinfoapp.db.SubwayDatabase
import com.hegunhee.subwayarrivalinfoapp.db.SubwayInfoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context : Context) : SubwayDatabase{
        return Room.databaseBuilder(context,SubwayDatabase::class.java,SubwayDatabase.DB_NAME).build()
    }

    @Singleton
    @Provides
    fun provideSubwayInfoDao(database : SubwayDatabase) : SubwayInfoDao {
        return database.SubwayInfoDao()
    }

    @Singleton
    @Provides
    fun provideFavoritesDao(database: SubwayDatabase) : FavoritesDao{
        return database.FavoritesDao()
    }
}