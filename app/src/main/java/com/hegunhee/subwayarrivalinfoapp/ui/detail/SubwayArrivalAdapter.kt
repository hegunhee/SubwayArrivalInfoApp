package com.hegunhee.subwayarrivalinfoapp.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hegunhee.subwayarrivalinfoapp.data.json.subway_arrival.SubwayArrivalSmallDataWithStationLine
import com.hegunhee.subwayarrivalinfoapp.databinding.ItemSubwayArrivalBinding

class SubwayArrivalAdapter(
    private var arrivalSmallDataList: List<SubwayArrivalSmallDataWithStationLine>,
    private val actionHandler : DetailFragmentActionHandler,
    private val station_name : String
) : RecyclerView.Adapter<SubwayArrivalAdapter.SubwayArrivalViewHolder>() {

    inner class SubwayArrivalViewHolder(private val binding : ItemSubwayArrivalBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(subwayInfo: SubwayArrivalSmallDataWithStationLine) = with(binding) {
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
        holder.bind(arrivalSmallDataList[position])
    }

    override fun getItemCount(): Int {
        return arrivalSmallDataList.size
    }

    fun setData(list : List<SubwayArrivalSmallDataWithStationLine>){
        arrivalSmallDataList = list
        notifyDataSetChanged()
    }
}