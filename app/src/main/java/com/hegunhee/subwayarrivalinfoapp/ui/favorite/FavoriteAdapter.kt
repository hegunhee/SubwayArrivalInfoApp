package com.hegunhee.subwayarrivalinfoapp.ui.favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hegunhee.subwayarrivalinfoapp.data.entity.Favorites
import com.hegunhee.subwayarrivalinfoapp.databinding.ItemFavoriteBinding

class FavoriteAdapter(
    private val eventHandler: FavoriteFragmentActionHandler
) : ListAdapter<Favorites,FavoriteAdapter.FavoriteViewHolder>(diffUtil){
    inner class FavoriteViewHolder(private val binding : ItemFavoriteBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(favorites: Favorites) = with(binding){
            favorite = favorites
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

internal object diffUtil : DiffUtil.ItemCallback<Favorites>(){
    override fun areItemsTheSame(oldItem: Favorites, newItem: Favorites): Boolean =
        oldItem.subwayInfo == newItem.subwayInfo
    override fun areContentsTheSame(oldItem: Favorites, newItem: Favorites): Boolean =
        oldItem == newItem

}