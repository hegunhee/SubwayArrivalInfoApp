package com.hegunhee.subwayarrivalinfoapp.ui.detail

import com.hegunhee.subwayarrivalinfoapp.data.json.subway_arrival.SubwayArrivalSmallDataWithFavorite

sealed class SubwayArrivalListState {

    object Initialized : SubwayArrivalListState()

    data class Success(val subwayInfoList : List<SubwayArrivalSmallDataWithFavorite>) : SubwayArrivalListState()

    object Failure : SubwayArrivalListState()
}