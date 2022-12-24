package com.hegunhee.subwayarrivalinfoapp.ui.common

import android.content.res.ColorStateList
import android.widget.ImageButton
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.hegunhee.subwayarrivalinfoapp.R

@BindingAdapter("isBookMarked")
fun ImageButton.setColors(isBookMarked : Boolean){
    val imageButtonColor = if(isBookMarked) R.color.yellow else R.color.black
    backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(context,imageButtonColor))
}