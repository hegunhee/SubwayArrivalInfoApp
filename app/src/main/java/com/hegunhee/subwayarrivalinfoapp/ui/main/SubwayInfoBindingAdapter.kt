package com.hegunhee.subwayarrivalinfoapp.ui.main

import androidx.databinding.BindingAdapter
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.hegunhee.subwayarrivalinfoapp.Util.SubwayLineColor
import com.hegunhee.subwayarrivalinfoapp.Util.setColor

@BindingAdapter("setChips")
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