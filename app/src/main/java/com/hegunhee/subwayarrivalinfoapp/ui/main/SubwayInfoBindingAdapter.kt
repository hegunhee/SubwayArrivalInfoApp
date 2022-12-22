package com.hegunhee.subwayarrivalinfoapp.ui.main

import android.content.res.ColorStateList
import android.widget.ImageButton
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.hegunhee.subwayarrivalinfoapp.R
import com.hegunhee.subwayarrivalinfoapp.Util.SubwayLineColor
import com.hegunhee.subwayarrivalinfoapp.Util.setColor

@BindingAdapter("setSubwayLines")
fun ChipGroup.setChips(subwayLine : List<String>?){
    removeAllViews()
    subwayLine?.forEach { line ->
        addView(Chip(context).apply {
            text = line
            for(subwayColor in SubwayLineColor.values()){
                if(subwayColor.line == line){
                    setColor(subwayColor.getColor())
                }
            }
        })
    }
}

@BindingAdapter("isBookMarked")
fun ImageButton.setColors(isBookMarked : Boolean){
    val imageButtonColor = if(isBookMarked) R.color.yellow else R.color.black
    backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(context,imageButtonColor))
}