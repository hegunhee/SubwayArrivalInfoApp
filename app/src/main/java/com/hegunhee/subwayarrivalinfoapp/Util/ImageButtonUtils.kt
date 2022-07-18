package com.hegunhee.subwayarrivalinfoapp.Util

import android.content.res.ColorStateList
import android.view.View
import android.widget.ImageButton
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat

fun ImageButton.setColor(@ColorRes color : Int){
    backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(context,color))
}
