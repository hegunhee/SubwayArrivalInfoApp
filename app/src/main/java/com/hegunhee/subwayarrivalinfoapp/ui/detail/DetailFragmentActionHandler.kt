package com.hegunhee.subwayarrivalinfoapp.ui.detail

import com.hegunhee.subwayarrivalinfoapp.data.json.subway_arrival.SubwayArrivalSmallDataWithStationLine

interface DetailFragmentActionHandler {

    fun toggleFavorite(subwayArrivalData : SubwayArrivalSmallDataWithStationLine, stationName : String)
}