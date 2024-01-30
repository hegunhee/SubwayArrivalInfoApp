package com.hegunhee.subwayarrivalinfoapp.ui.main

import com.hegunhee.subwayarrivalinfoapp.data.entity.SubwayInfoEntity

interface MainActionHandler {

    fun toggleSubwayInfoBookMarked(subwayInfoEntity: SubwayInfoEntity)

    fun navigateToDetail(subwayName : String)

    fun navigateToFavorite()
}