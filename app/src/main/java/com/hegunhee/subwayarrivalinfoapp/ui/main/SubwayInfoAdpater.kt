package com.hegunhee.subwayarrivalinfoapp.ui.main

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import com.hegunhee.subwayarrivalinfoapp.R
import com.hegunhee.subwayarrivalinfoapp.Util.SubwayLineColor
import com.hegunhee.subwayarrivalinfoapp.data.entity.SubwayInfoEntity
import com.hegunhee.subwayarrivalinfoapp.databinding.ItemMainAdapterBinding

class SubwayInfoAdpater(
    private var subwayInfoList : List<SubwayInfoEntity>,
    private val toggleSubwayInfo : (SubwayInfoEntity) -> Unit
) : RecyclerView.Adapter<SubwayInfoAdpater.MainViewHolder>() {

    inner class MainViewHolder(private val binding : ItemMainAdapterBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(subwayInfoEntity: SubwayInfoEntity) = with(binding) {
            chipGroup.removeAllViews()
            subwayName.text = subwayInfoEntity.subwayName
            subwayInfoEntity.subwayLine.forEach {
                chipGroup.addView(Chip(chipGroup.context).apply {
                    text = it
                    for(subwayColor in SubwayLineColor.values()){
                        if(subwayColor.line == it){
                            this.chipBackgroundColor = ColorStateList.valueOf(ContextCompat.getColor(this.context,subwayColor.getColor()))
                        }
                    }
                })
            }
            val imageButtonColor = if(subwayInfoEntity.isBookmarked) R.color.yellow else R.color.black
            imageButton.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(this.imageButton.context,imageButtonColor))
        }
        fun initListener(subwayInfoEntity: SubwayInfoEntity) = with(binding){
            imageButton.setOnClickListener {
                toggleSubwayInfo(subwayInfoEntity.copy(isBookmarked = !subwayInfoEntity.isBookmarked))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(ItemMainAdapterBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(subwayInfoList[position])
        holder.initListener(subwayInfoList[position])
    }

    override fun getItemCount(): Int = subwayInfoList.size

    fun setData(list : List<SubwayInfoEntity>){
        subwayInfoList = list
        notifyDataSetChanged()
    }
}