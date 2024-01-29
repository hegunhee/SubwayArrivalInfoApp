package com.hegunhee.subwayarrivalinfoapp.data

import com.hegunhee.subwayarrivalinfoapp.Util.subway_line_limit
import com.hegunhee.subwayarrivalinfoapp.data.entity.SubwayInfoEntity
import com.hegunhee.subwayarrivalinfoapp.data.json.subway_info.Row
import com.hegunhee.subwayarrivalinfoapp.data.json.subway_info.SubwaySearchInfoResponse

fun SubwaySearchInfoResponse.toSubwayInfoEntityList() : List<SubwayInfoEntity> {
    val subwayInfo = this
    return subwayInfo.row.filter {it.getFormattedLineNum() in subway_line_limit}.groupBy { it.stationNm }.map { subway ->
        subway.value.toSubwayInfoEntity(subway.key)
    }
}

fun List<Row>.toSubwayInfoEntity(stationName : String) : SubwayInfoEntity {
    return SubwayInfoEntity(stationName,this.map { it.getFormattedLineNum() })
}