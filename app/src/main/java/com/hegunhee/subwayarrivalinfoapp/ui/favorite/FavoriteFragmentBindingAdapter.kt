package com.hegunhee.subwayarrivalinfoapp.ui.favorite

import androidx.databinding.BindingAdapter
import com.google.android.material.chip.Chip
import com.hegunhee.subwayarrivalinfoapp.Util.SubwayLineColor
import com.hegunhee.subwayarrivalinfoapp.Util.setColor


@BindingAdapter("setSubwayLineColor")
fun Chip.setChipColor(subwayLine : String){
    for(subwayColor in SubwayLineColor.values()){
        if(subwayColor.line == subwayLine){
            setColor(subwayColor.getColor())
        }
    }
}