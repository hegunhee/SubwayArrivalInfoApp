package com.hegunhee.subwayarrivalinfoapp.ui.main

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.hegunhee.subwayarrivalinfoapp.Util.SubwayLineColor
import com.hegunhee.subwayarrivalinfoapp.Util.setColor

//@BindingAdapter("setSubwayLines")
//fun ChipGroup.setChips(subwayLine : List<String>?){
//    removeAllViews()
//    subwayLine?.forEach { line ->
//        addView(Chip(context).apply {
//            text = line
//            for(subwayColor in SubwayLineColor.values()){
//                if(subwayColor.line == line){
//                    setColor(subwayColor.getColor())
//                }
//            }
//        })
//    }
//}

@BindingAdapter("setSubwayLines")
fun RecyclerView.setSubwayLines(subwayLine: List<String>?) {
    subwayLine?.let { subwayLineList ->
        val subwayLineAdapter = SubwayLineAdapter()
        adapter = subwayLineAdapter
        subwayLineAdapter.submitList(subwayLineList)
    }
}