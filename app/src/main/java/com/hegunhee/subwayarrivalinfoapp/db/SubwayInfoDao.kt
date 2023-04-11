package com.hegunhee.subwayarrivalinfoapp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.hegunhee.subwayarrivalinfoapp.data.entity.SubwayInfoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SubwayInfoDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertSubwayInfoList(subwayInfoList : List<SubwayInfoEntity>)

    @Update
    suspend fun toggleSubwayInfoBookMarked(subwayInfoEntity: SubwayInfoEntity)

    @Query("SELECT * FROM subwayInfoEntity ORDER BY isBookmarked DESC")
    fun getAllSubwayInfoByFlow() : Flow<List<SubwayInfoEntity>>

    @Query("SELECT * FROM subwayInfoEntity WHERE subwayName == :name")
    fun getSubwayInfoByName(name : String) : SubwayInfoEntity?
}