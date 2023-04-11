package com.hegunhee.subwayarrivalinfoapp.ui.main

import com.hegunhee.subwayarrivalinfoapp.data.entity.SubwayInfoEntity

interface MainFragmentActionHandler {

    fun toggleSubwayInfoBookMarked(subwayInfoEntity: SubwayInfoEntity)

    fun navigateToDetail(subwayName : String)
}