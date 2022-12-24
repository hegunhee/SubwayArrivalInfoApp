package com.hegunhee.subwayarrivalinfoapp.ui.detail

import android.content.res.ColorStateList
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.hegunhee.subwayarrivalinfoapp.R
import com.hegunhee.subwayarrivalinfoapp.Util.SubwayLineColor
import com.hegunhee.subwayarrivalinfoapp.Util.setColor
import com.hegunhee.subwayarrivalinfoapp.data.entity.Favorites
import com.hegunhee.subwayarrivalinfoapp.data.json.subway_arrival.SubwayArrivalSmallDataWithStationLine
import com.hegunhee.subwayarrivalinfoapp.databinding.ItemSubwayArrivalBinding

class SubwayArrivalAdapter(
    private var arrivalSmallDataList: List<SubwayArrivalSmallDataWithStationLine>,
    private val insertFavorite : (Favorites) -> Unit,
    private val deleteFavorite : (String) -> Unit,
    private val station_name : String
) : RecyclerView.Adapter<SubwayArrivalAdapter.SubwayArrivalViewHolder>() {

    inner class SubwayArrivalViewHolder(private val binding : ItemSubwayArrivalBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(subwayInfo: SubwayArrivalSmallDataWithStationLine) = with(binding) {
            subwayArrivalData = subwayInfo
            stationInfo.text = subwayInfo.fullName
            time.text = "${subwayInfo.time/60} 분 ${subwayInfo.time%60} 초"
            message.text = subwayInfo.message
            stationLine.text = subwayInfo.station_line
            for(subwayColor in SubwayLineColor.values()){
                if(subwayColor.line == subwayInfo.station_line){
                    stationLine.setColor(subwayColor.getColor())
                }
            }
            star.setOnClickListener {
                if(star.backgroundTintList == ColorStateList.valueOf(ContextCompat.getColor(this.star.context,R.color.yellow))){
                    deleteFavorite(subwayInfo.fullName)
                }else{
                    insertFavorite(subwayInfo.toFavorites(station_name))
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