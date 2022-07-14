package com.hegunhee.subwayarrivalinfoapp.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hegunhee.subwayarrivalinfoapp.data.json.subway_arrival.SubwayArrivalSmallData
import com.hegunhee.subwayarrivalinfoapp.databinding.ItemSubwayArrivalBinding

class SubwayArrivalAdapter(
    private var arrivalSmallDataList: List<SubwayArrivalSmallData>
) : RecyclerView.Adapter<SubwayArrivalAdapter.SubwayArrivalViewHolder>() {

    inner class SubwayArrivalViewHolder(private val binding : ItemSubwayArrivalBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(subwayArrivalSmallData: SubwayArrivalSmallData) = with(binding) {
            stationInfo.text = subwayArrivalSmallData.fullName
            time.text = "${subwayArrivalSmallData.time/60} 분 ${subwayArrivalSmallData.time%60}"
            message.text = subwayArrivalSmallData.message
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

    fun setData(list : List<SubwayArrivalSmallData>){
        arrivalSmallDataList = list
        notifyDataSetChanged()
    }
}