package com.hegunhee.subwayarrivalinfoapp.ui.favorite.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hegunhee.subwayarrivalinfoapp.data.json.subway_arrival.SubwayArrivalSmallDataWithFavorite
import com.hegunhee.subwayarrivalinfoapp.databinding.ItemFavoriteDetailBinding

class FavoriteDetailAdapter() : ListAdapter<SubwayArrivalSmallDataWithFavorite,FavoriteDetailAdapter.FavoriteDetailViewHolder>(diff_util) {

    inner class FavoriteDetailViewHolder(private val binding : ItemFavoriteDetailBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(subway : SubwayArrivalSmallDataWithFavorite) = with(binding){
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
internal object diff_util : DiffUtil.ItemCallback<SubwayArrivalSmallDataWithFavorite>() {
    override fun areItemsTheSame(
        oldItem: SubwayArrivalSmallDataWithFavorite,
        newItem: SubwayArrivalSmallDataWithFavorite
    ): Boolean =
        oldItem.fullName == newItem.fullName


    override fun areContentsTheSame(
        oldItem: SubwayArrivalSmallDataWithFavorite,
        newItem: SubwayArrivalSmallDataWithFavorite
    ): Boolean =
        oldItem == newItem
}