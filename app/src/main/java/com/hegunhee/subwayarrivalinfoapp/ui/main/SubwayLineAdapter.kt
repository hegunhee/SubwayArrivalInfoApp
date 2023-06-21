package com.hegunhee.subwayarrivalinfoapp.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.hegunhee.subwayarrivalinfoapp.databinding.ItemSubwayLineBinding

class SubwayLineAdapter() : ListAdapter<String,SubwayLineAdapter.SubwayLineViewHolder>(diff_util) {

    inner class SubwayLineViewHolder(private val binding : ItemSubwayLineBinding) : ViewHolder(binding.root){

        fun bind(subwayLine : String) {
            binding.subwayLine = subwayLine
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubwayLineViewHolder {
        return SubwayLineViewHolder(ItemSubwayLineBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: SubwayLineViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

internal object diff_util : DiffUtil.ItemCallback<String>(){
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

}