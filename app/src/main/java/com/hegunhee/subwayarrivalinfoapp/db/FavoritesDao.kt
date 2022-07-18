package com.hegunhee.subwayarrivalinfoapp.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.hegunhee.subwayarrivalinfoapp.data.entity.Favorites
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoritesDao {

    @Insert
    suspend fun insertFavorites(favorites: Favorites)

    @Query("DELETE FROM favorites WHERE subway_info = :subway_info")
    suspend fun deleteFavorites(subway_info: String)

    @Query("SELECT * FROM favorites")
    fun getFavoritesByFlow() : Flow<List<Favorites>>
}