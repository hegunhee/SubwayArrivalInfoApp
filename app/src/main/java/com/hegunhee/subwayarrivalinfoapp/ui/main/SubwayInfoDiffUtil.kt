package com.hegunhee.subwayarrivalinfoapp.ui.main

import androidx.recyclerview.widget.DiffUtil
import com.hegunhee.subwayarrivalinfoapp.data.entity.SubwayInfoEntity

class SubwayInfoDiffUtil(private val oldList : List<SubwayInfoEntity>, private val newList : List<SubwayInfoEntity>) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].subwayName == newList[newItemPosition].subwayName
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }


}