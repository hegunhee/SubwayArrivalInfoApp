package com.hegunhee.subwayarrivalinfoapp.data.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Favorites(
    @PrimaryKey val subwayInfo : String,
    val subwayName : String,
    val subwayLine : String
) : Parcelable