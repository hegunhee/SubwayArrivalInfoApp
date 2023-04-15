package com.hegunhee.subwayarrivalinfoapp.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hegunhee.subwayarrivalinfoapp.data.json.subway_arrival.SubwayArrivalSmallDataWithFavorite
import com.hegunhee.subwayarrivalinfoapp.databinding.ItemSubwayArrivalBinding

class SubwayArrivalAdapter(
    private val actionHandler : DetailFragmentActionHandler,
    private val station_name : String
) : ListAdapter<SubwayArrivalSmallDataWithFavorite,SubwayArrivalAdapter.SubwayArrivalViewHolder>(diffUtil) {

    inner class SubwayArrivalViewHolder(private val binding : ItemSubwayArrivalBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(subwayInfo: SubwayArrivalSmallDataWithFavorite) = with(binding) {
            stationName = station_name
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
}

internal object diffUtil : DiffUtil.ItemCallback<SubwayArrivalSmallDataWithFavorite>() {
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