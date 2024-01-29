package com.hegunhee.subwayarrivalinfoapp.data

import com.hegunhee.subwayarrivalinfoapp.util.subway_line_limit
import com.hegunhee.subwayarrivalinfoapp.data.entity.SubwayInfoEntity
import com.hegunhee.subwayarrivalinfoapp.data.json.subway_arrival.RealtimeArrivalResponse
import com.hegunhee.subwayarrivalinfoapp.data.json.subway_info.Row
import com.hegunhee.subwayarrivalinfoapp.data.json.subway_info.SubwaySearchInfoResponse
import com.hegunhee.subwayarrivalinfoapp.model.SubwayArrivalInfo

fun SubwaySearchInfoResponse.toSubwayInfoEntityList() : List<SubwayInfoEntity> {
    val subwayInfo = this
    return subwayInfo.row.filter {it.getFormattedLineNum() in subway_line_limit}.groupBy { it.stationNm }.map { subway ->
        subway.value.toSubwayInfoEntity(subway.key)
    }
}

fun List<Row>.toSubwayInfoEntity(stationName : String) : SubwayInfoEntity {
    return SubwayInfoEntity(stationName,this.map { it.getFormattedLineNum() })
}

fun RealtimeArrivalResponse.toSubwayArrivalInfo(isFavorite : Boolean) : SubwayArrivalInfo {
    return SubwayArrivalInfo(
        nextStation = bstatnNm,
        time = barvlDt.toInt(),
        message = arvlMsg2,
        fullName = trainLineNm,
        stationLine = subwayId.toSubwayLine(),
        isFavorite = isFavorite
    )
}

/**
지하철호선ID(subwayId)
1001:1호선, 1002:2호선, 1003:3호선, 1004:4호선, 1005:5호선 1006:6호선, 1007:7호선, 1008:8호선, 1009:9호선
 **/
private fun String.toSubwayLine(): String {
    return "${this.toInt() % 10}호선"
}