package com.hegunhee.subwayarrivalinfoapp.ui.favorite.detail

import com.hegunhee.subwayarrivalinfoapp.model.SubwayArrivalInfo

sealed class SubwayInfoListState {

    object Initialized : SubwayInfoListState()

    data class Success(val subwayInfoList : List<SubwayArrivalInfo>) : SubwayInfoListState()

    object Failure : SubwayInfoListState()
}