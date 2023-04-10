package com.hegunhee.subwayarrivalinfoapp.data.json.subway_arrival


import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RealtimeArrival(
    @Json(name = "arvlCd") val arvlCd: String,
    @Json(name = "arvlMsg2") val arvlMsg2: String,
    @Json(name = "arvlMsg3") val arvlMsg3: String,
    @Json(name = "barvlDt") val barvlDt: String,
    @Json(name = "beginRow") val beginRow: Any?,
    @Json(name ="bstatnId") val bstatnId: String,
    @Json(name = "bstatnNm") val bstatnNm: String,
    @Json(name = "btrainNo") val btrainNo: String,
    @Json(name = "btrainSttus") val btrainSttus: Any,
    @Json(name ="curPage") val curPage: Any,
    @Json(name ="endRow") val endRow: Any?,
    @Json(name = "ordkey") val ordkey: String,
    @Json(name ="pageRow") val pageRow: Any,
    @Json(name ="recptnDt") val recptnDt: String,
    @Json( name = "rowNum") val rowNum: Int,
    @Json(name ="selectedCount") val selectedCount: Int,
    @Json(name ="statnFid") val statnFid: String,
    @Json(name ="statnId") val statnId: String,
    @Json(name ="statnList") val statnList: String,
    @Json(name ="statnNm") val statnNm: String,
    @Json(name ="statnTid") val statnTid: String,
    @Json(name ="subwayHeading") val subwayHeading: String,
    @Json(name ="subwayId") val subwayId: String,
    @Json(name ="subwayList") val subwayList: String,
    @Json(name ="subwayNm") val subwayNm: Any,
    @Json(name ="totalCount") val totalCount: Int,
    @Json(name ="trainCo") val trainCo: Any,
    @Json(name ="trainLineNm") val trainLineNm: String,
    @Json(name ="updnLine") val updnLine: String
) {
    fun toSmallData() : SubwayArrivalSmallData{
        return SubwayArrivalSmallData(bstatnNm,barvlDt.toInt(),arvlMsg2,trainLineNm)
    }
}