package com.hegunhee.subwayarrivalinfoapp.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Favorites(
    @PrimaryKey val subway_info : String,
    val subway_name : String,
    val subway_line : String
)