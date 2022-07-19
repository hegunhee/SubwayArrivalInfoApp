package com.hegunhee.subwayarrivalinfoapp.data.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Favorites(
    @PrimaryKey val subway_info : String,
    val subway_name : String,
    val subway_line : String
) : Parcelable