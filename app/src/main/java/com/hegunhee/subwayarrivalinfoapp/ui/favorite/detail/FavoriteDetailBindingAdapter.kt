package com.hegunhee.subwayarrivalinfoapp.ui.favorite

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("setTime")
fun TextView.setTimeText(hour : Int){
    text = "${hour/60} 분 ${hour%60} 초"
}