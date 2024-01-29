package com.hegunhee.subwayarrivalinfoapp.ui.detail

import com.hegunhee.subwayarrivalinfoapp.model.SubwayArrivalInfo

sealed class SubwayArrivalListState {

    object Initialized : SubwayArrivalListState()

    data class Success(val subwayInfoList : List<SubwayArrivalInfo>) : SubwayArrivalListState()

    object Failure : SubwayArrivalListState()
}