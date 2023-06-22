package com.hegunhee.subwayarrivalinfoapp.ui.main

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("setSubwayLines")
fun RecyclerView.setSubwayLines(subwayLine: List<String>?) {
    subwayLine?.let { subwayLineList ->
        val subwayLineAdapter = SubwayLineAdapter()
        adapter = subwayLineAdapter
        subwayLineAdapter.submitList(subwayLineList)
    }
}