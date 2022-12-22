package com.hegunhee.subwayarrivalinfoapp.ui.main

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import com.hegunhee.subwayarrivalinfoapp.R
import com.hegunhee.subwayarrivalinfoapp.Util.SubwayLineColor
import com.hegunhee.subwayarrivalinfoapp.Util.setColor
import com.hegunhee.subwayarrivalinfoapp.data.entity.SubwayInfoEntity
import com.hegunhee.subwayarrivalinfoapp.databinding.ItemSubwayInfoBinding

class SubwayInfoAdpater(
    private val subwayInfoList : ArrayList<SubwayInfoEntity>,
    private val eventHandler: MainFragmentActionHandler
) : RecyclerView.Adapter<SubwayInfoAdpater.MainViewHolder>() {

    inner class MainViewHolder(private val binding : ItemSubwayInfoBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(subwayInfoEntity: SubwayInfoEntity) = with(binding) {
            this.subwayInfoEntity = subwayInfoEntity
            val imageButtonColor = if(subwayInfoEntity.isBookmarked) R.color.yellow else R.color.black
            imageButton.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(this.imageButton.context,imageButtonColor))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(ItemSubwayInfoBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            .apply {
                eventHandler = this@SubwayInfoAdpater.eventHandler
            })
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(subwayInfoList[position])
    }

    override fun getItemCount(): Int = subwayInfoList.size

    fun setData(list : List<SubwayInfoEntity>){
        val diffCallback = SubwayInfoDiffUtil(subwayInfoList,list)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        subwayInfoList.run {
            clear()
            addAll(list)
            diffResult.dispatchUpdatesTo(this@SubwayInfoAdpater)
        }
    }
}