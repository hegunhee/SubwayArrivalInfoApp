package com.hegunhee.subwayarrivalinfoapp.ui.common

import android.content.res.ColorStateList
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.google.android.material.chip.Chip
import com.hegunhee.subwayarrivalinfoapp.R
import com.hegunhee.subwayarrivalinfoapp.Util.SubwayLineColor
import com.hegunhee.subwayarrivalinfoapp.Util.setColor

@BindingAdapter("isBookMarked")
fun ImageButton.setColors(isBookMarked : Boolean){
    val imageButtonColor = if(isBookMarked) R.color.yellow else R.color.black
    backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(context,imageButtonColor))
}

@BindingAdapter("setSubwayLineColor")
fun Chip.setChipColor(subwayLine : String){
    for(subwayColor in SubwayLineColor.values()){
        if(subwayColor.line == subwayLine){
            setColor(subwayColor.getColor())
        }
    }
}

@BindingAdapter("setTime")
fun TextView.setTimeText(hour : Int){
    text = "${hour/60} 분 ${hour%60} 초"
}

@BindingAdapter("setStationLineBackground")
fun TextView.setBackgroundColor(subwayLine : String) {
    SubwayLineColor.values().firstOrNull { it.line == subwayLine }?.let {
        backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(context,it.getColor()))
    }
}