package com.hegunhee.subwayarrivalinfoapp.Util

import android.content.res.ColorStateList
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import com.google.android.material.chip.Chip


fun Chip.setColor(@ColorRes color : Int){
    chipBackgroundColor = ColorStateList.valueOf(ContextCompat.getColor(context,color))
}