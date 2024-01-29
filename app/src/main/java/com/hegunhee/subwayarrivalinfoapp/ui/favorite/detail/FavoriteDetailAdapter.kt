package com.hegunhee.subwayarrivalinfoapp.ui.favorite.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hegunhee.subwayarrivalinfoapp.model.SubwayArrivalInfo
import com.hegunhee.subwayarrivalinfoapp.databinding.ItemFavoriteDetailBinding

class FavoriteDetailAdapter() : ListAdapter<SubwayArrivalInfo,FavoriteDetailAdapter.FavoriteDetailViewHolder>(diff_util) {

    inner class FavoriteDetailViewHolder(private val binding : ItemFavoriteDetailBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(subway : SubwayArrivalInfo) = with(binding){
            subwayArrivaldata = subway
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteDetailViewHolder {
        return FavoriteDetailViewHolder(ItemFavoriteDetailBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: FavoriteDetailViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}
internal object diff_util : DiffUtil.ItemCallback<SubwayArrivalInfo>() {
    override fun areItemsTheSame(
        oldItem: SubwayArrivalInfo,
        newItem: SubwayArrivalInfo
    ): Boolean =
        oldItem.fullName == newItem.fullName


    override fun areContentsTheSame(
        oldItem: SubwayArrivalInfo,
        newItem: SubwayArrivalInfo
    ): Boolean =
        oldItem == newItem
}