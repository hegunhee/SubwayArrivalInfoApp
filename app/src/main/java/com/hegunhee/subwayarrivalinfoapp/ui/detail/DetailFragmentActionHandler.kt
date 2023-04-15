package com.hegunhee.subwayarrivalinfoapp.ui.detail

import com.hegunhee.subwayarrivalinfoapp.data.json.subway_arrival.SubwayArrivalSmallDataWithFavorite

interface DetailFragmentActionHandler {

    fun toggleFavorite(subwayArrivalData : SubwayArrivalSmallDataWithFavorite, stationName : String)
}