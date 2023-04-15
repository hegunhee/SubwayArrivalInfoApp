package com.hegunhee.subwayarrivalinfoapp.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hegunhee.subwayarrivalinfoapp.data.entity.SubwayInfoEntity
import com.hegunhee.subwayarrivalinfoapp.databinding.ItemSubwayInfoBinding

class SubwayInfoAdapter(
    private val eventHandler: MainFragmentActionHandler
) : ListAdapter<SubwayInfoEntity,SubwayInfoAdapter.MainViewHolder>(diffUtil) {

    inner class MainViewHolder(private val binding : ItemSubwayInfoBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(subwayInfoEntity: SubwayInfoEntity) = with(binding) {
            this.subwayInfoEntity = subwayInfoEntity
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(ItemSubwayInfoBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            .apply {
                eventHandler = this@SubwayInfoAdapter.eventHandler
            })
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

internal object diffUtil : DiffUtil.ItemCallback<SubwayInfoEntity>(){
    override fun areItemsTheSame(oldItem: SubwayInfoEntity, newItem: SubwayInfoEntity): Boolean =
        oldItem.subwayName == newItem.subwayName

    override fun areContentsTheSame(oldItem: SubwayInfoEntity, newItem: SubwayInfoEntity): Boolean =
        oldItem == newItem
}