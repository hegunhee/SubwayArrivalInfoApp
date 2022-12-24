package com.hegunhee.subwayarrivalinfoapp.ui.favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hegunhee.subwayarrivalinfoapp.Util.SubwayLineColor
import com.hegunhee.subwayarrivalinfoapp.Util.setColor
import com.hegunhee.subwayarrivalinfoapp.data.entity.Favorites
import com.hegunhee.subwayarrivalinfoapp.databinding.ItemFavoriteBinding

class FavoriteAdapter(
    private val eventHandler: FavoriteFragmentActionHandler
) : ListAdapter<Favorites,FavoriteAdapter.FavoriteViewHolder>(diff_util){
    inner class FavoriteViewHolder(private val binding : ItemFavoriteBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(favorites: Favorites) = with(binding){
            favorite = favorites
            stationInfo.text = favorites.subway_info
            stationName.text = favorites.subway_name
            stationLine.text = favorites.subway_line
            for(subwayColor in SubwayLineColor.values()){
                if(subwayColor.line == favorites.subway_line){
                    stationLine.setColor(subwayColor.getColor())
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        return FavoriteViewHolder(ItemFavoriteBinding.inflate(LayoutInflater.from(parent.context),parent,false).apply {
            eventHandler = this@FavoriteAdapter.eventHandler
        })
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

internal object diff_util : DiffUtil.ItemCallback<Favorites>(){
    override fun areItemsTheSame(oldItem: Favorites, newItem: Favorites): Boolean =
        oldItem.subway_info == newItem.subway_info
    override fun areContentsTheSame(oldItem: Favorites, newItem: Favorites): Boolean =
        oldItem == newItem

}