package com.hegunhee.subwayarrivalinfoapp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hegunhee.subwayarrivalinfoapp.data.entity.SubwayInfoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SubwayInfoDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertSubwayInfoList(subwayInfoList : List<SubwayInfoEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun toggleSubwayInfo(subwayInfoEntity: SubwayInfoEntity)

    @Query("SELECT * FROM subwayInfoEntity ORDER BY isBookmarked DESC")
    fun getAllSubwayInfoByFlow() : Flow<List<SubwayInfoEntity>>
}