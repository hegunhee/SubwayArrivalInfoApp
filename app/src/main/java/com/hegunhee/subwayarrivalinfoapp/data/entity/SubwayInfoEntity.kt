package com.hegunhee.subwayarrivalinfoapp.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SubwayInfoEntity(
    @PrimaryKey val subwayName : String,
    val subwayLine : List<String>,
    val isBookmarked : Boolean = false
) {
}