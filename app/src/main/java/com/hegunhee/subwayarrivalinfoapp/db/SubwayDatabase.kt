package com.hegunhee.subwayarrivalinfoapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.hegunhee.subwayarrivalinfoapp.data.entity.Favorites
import com.hegunhee.subwayarrivalinfoapp.data.entity.SubwayInfoEntity

@Database(entities = [SubwayInfoEntity::class,Favorites::class], version = 1, exportSchema = false)
@TypeConverters(MyTypeConverters::class)
abstract class SubwayDatabase : RoomDatabase() {

    abstract fun SubwayInfoDao() : SubwayInfoDao

    abstract fun FavoritesDao() : FavoritesDao

    companion object{
        const val DB_NAME = "SubwayDatabase.db"
    }
}