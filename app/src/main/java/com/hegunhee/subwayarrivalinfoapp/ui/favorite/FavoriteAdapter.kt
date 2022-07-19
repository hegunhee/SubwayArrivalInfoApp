package com.hegunhee.subwayarrivalinfoapp.ui.favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hegunhee.subwayarrivalinfoapp.Util.SubwayLineColor
import com.hegunhee.subwayarrivalinfoapp.Util.setColor
import com.hegunhee.subwayarrivalinfoapp.data.entity.Favorites
import com.hegunhee.subwayarrivalinfoapp.databinding.ItemFavoriteBinding

class FavoriteAdapter(
    private var favoriteList : List<Favorites>,
    private val deleteFavorite : (String) -> Unit
) : RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>(){
    inner class FavoriteViewHolder(private val binding : ItemFavoriteBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(favorites: Favorites) = with(binding){
            stationInfo.text = favorites.subway_info
            stationName.text = favorites.subway_name
            stationLine.text = favorites.subway_line
            for(subwayColor in SubwayLineColor.values()){
                if(subwayColor.line == favorites.subway_line){
                    stationLine.setColor(subwayColor.getColor())
                }
            }
            star.setOnClickListener {
                deleteFavorite(favorites.subway_info)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        return FavoriteViewHolder(ItemFavoriteBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.bind(favoriteList[position])
    }

    override fun getItemCount(): Int = favoriteList.size

    fun setData(list : List<Favorites>){
        favoriteList = list
        notifyDataSetChanged()
    }
}