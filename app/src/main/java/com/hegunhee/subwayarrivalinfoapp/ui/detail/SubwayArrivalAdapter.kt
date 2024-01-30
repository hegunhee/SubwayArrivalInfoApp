package com.hegunhee.subwayarrivalinfoapp.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hegunhee.subwayarrivalinfoapp.model.SubwayArrivalInfo
import com.hegunhee.subwayarrivalinfoapp.databinding.ItemSubwayArrivalBinding

class SubwayArrivalAdapter(
    private val actionHandler : DetailActionHandler,
    private val stationName : String
) : ListAdapter<SubwayArrivalInfo,SubwayArrivalAdapter.SubwayArrivalViewHolder>(diffUtil) {

    inner class SubwayArrivalViewHolder(private val binding : ItemSubwayArrivalBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(subwayInfo: SubwayArrivalInfo) = with(binding) {
            stationName = this@SubwayArrivalAdapter.stationName
            subwayArrivalData = subwayInfo
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubwayArrivalViewHolder {
        return SubwayArrivalViewHolder(ItemSubwayArrivalBinding.inflate(LayoutInflater.from(parent.context),parent,false).apply {
            eventHandler = actionHandler

        })
    }

    override fun onBindViewHolder(holder: SubwayArrivalViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
    companion object {
        private val diffUtil = object :  DiffUtil.ItemCallback<SubwayArrivalInfo>() {
            override fun areItemsTheSame(oldItem: SubwayArrivalInfo, newItem: SubwayArrivalInfo): Boolean =
                oldItem.fullName == newItem.fullName

            override fun areContentsTheSame(oldItem: SubwayArrivalInfo, newItem: SubwayArrivalInfo): Boolean =
                oldItem == newItem
        }
    }
}