package com.hegunhee.subwayarrivalinfoapp.ui.detail

import com.hegunhee.subwayarrivalinfoapp.model.SubwayArrivalInfo

interface DetailActionHandler {

    fun toggleFavorite(subwayArrivalData : SubwayArrivalInfo, stationName : String)
}