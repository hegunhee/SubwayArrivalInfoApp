package com.hegunhee.subwayarrivalinfoapp.ui.favorite.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hegunhee.subwayarrivalinfoapp.data.entity.Favorites
import com.hegunhee.subwayarrivalinfoapp.data.json.subway_arrival.SubwayArrivalSmallDataWithStationLine
import com.hegunhee.subwayarrivalinfoapp.databinding.ItemFavoriteDetailBinding

class FavoriteDetailAdapter() : ListAdapter<SubwayArrivalSmallDataWithStationLine,FavoriteDetailAdapter.FavoriteDetailViewHolder>(diff_util) {

    inner class FavoriteDetailViewHolder(private val binding : ItemFavoriteDetailBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(subway : SubwayArrivalSmallDataWithStationLine) = with(binding){
            time.text =  "${subway.time/60} 분 ${subway.time%60} 초"
            message.text = subway.message
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteDetailViewHolder {
        return FavoriteDetailViewHolder(ItemFavoriteDetailBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: FavoriteDetailViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}
internal object diff_util : DiffUtil.ItemCallback<SubwayArrivalSmallDataWithStationLine>() {
    override fun areItemsTheSame(
        oldItem: SubwayArrivalSmallDataWithStationLine,
        newItem: SubwayArrivalSmallDataWithStationLine
    ): Boolean =
        oldItem.fullName == newItem.fullName


    override fun areContentsTheSame(
        oldItem: SubwayArrivalSmallDataWithStationLine,
        newItem: SubwayArrivalSmallDataWithStationLine
    ): Boolean =
        oldItem == newItem
}