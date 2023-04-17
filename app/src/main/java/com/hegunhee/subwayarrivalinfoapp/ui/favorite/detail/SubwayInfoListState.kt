package com.hegunhee.subwayarrivalinfoapp.ui.favorite.detail

import com.hegunhee.subwayarrivalinfoapp.data.json.subway_arrival.SubwayArrivalSmallDataWithFavorite

sealed class SubwayInfoListState {

    object Initialized : SubwayInfoListState()

    data class Success(val subwayInfoList : List<SubwayArrivalSmallDataWithFavorite>) : SubwayInfoListState()

    object Failure : SubwayInfoListState()
}