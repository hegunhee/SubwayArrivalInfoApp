package com.hegunhee.subwayarrivalinfoapp.ui.detail

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.hegunhee.subwayarrivalinfoapp.Util.SubwayLineColor
import com.hegunhee.subwayarrivalinfoapp.Util.setColor
import com.hegunhee.subwayarrivalinfoapp.data.json.subway_arrival.SubwayArrivalSmallData
import com.hegunhee.subwayarrivalinfoapp.data.json.subway_arrival.SubwayArrivalSmallDataWithStationLine
import com.hegunhee.subwayarrivalinfoapp.databinding.ItemSubwayArrivalBinding

class SubwayArrivalAdapter(
    private var arrivalSmallDataList: List<SubwayArrivalSmallDataWithStationLine>
) : RecyclerView.Adapter<SubwayArrivalAdapter.SubwayArrivalViewHolder>() {

    inner class SubwayArrivalViewHolder(private val binding : ItemSubwayArrivalBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(subwayArrivalSmallDataWithSationLine: SubwayArrivalSmallDataWithStationLine) = with(binding) {
            stationInfo.text = subwayArrivalSmallDataWithSationLine.fullName
            time.text = "${subwayArrivalSmallDataWithSationLine.time/60} 분 ${subwayArrivalSmallDataWithSationLine.time%60} 초"
            message.text = subwayArrivalSmallDataWithSationLine.message
            stationLine.text = subwayArrivalSmallDataWithSationLine.station_line
            for(subwayColor in SubwayLineColor.values()){
                if(subwayColor.line == subwayArrivalSmallDataWithSationLine.station_line){
                    stationLine.setColor(subwayColor.getColor())
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubwayArrivalViewHolder {
        return SubwayArrivalViewHolder(ItemSubwayArrivalBinding.inflate(LayoutInflater.from(parent.context),parent,false))
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