package com.hegunhee.subwayarrivalinfoapp.db

import androidx.room.*
import com.hegunhee.subwayarrivalinfoapp.data.entity.Favorites
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoritesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertFavorites(favorites: Favorites)

    @Query("DELETE FROM favorites WHERE subwayInfo = :subway_info")
    suspend fun deleteFavorites(subway_info: String)

    @Query("SELECT * FROM favorites")
    fun getFavoritesListByFlow() : Flow<List<Favorites>>

    @Query("SELECT * FROM favorites")
    suspend fun getFavoritesList() : List<Favorites>
}