package com.hegunhee.subwayarrivalinfoapp.data.json.subway_arrival


import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RealtimeArrival(
    @Json(name = "arvlCd") val arvlCd: String?=null,
    @Json(name = "arvlMsg2") val arvlMsg2: String,
    @Json(name = "arvlMsg3") val arvlMsg3: String?= null,
    @Json(name = "barvlDt") val barvlDt: String,
    @Json(name = "beginRow") val beginRow: Any? = null,
    @Json(name ="bstatnId") val bstatnId: String?=null,
    @Json(name = "bstatnNm") val bstatnNm: String,
    @Json(name = "btrainNo") val btrainNo: String?=null,
    @Json(name = "btrainSttus") val btrainSttus: Any? = null,
    @Json(name ="curPage") val curPage: Any? = null,
    @Json(name ="endRow") val endRow: Any? = null,
    @Json(name = "ordkey") val ordkey: String?=null,
    @Json(name ="pageRow") val pageRow: Any? = null,
    @Json(name ="recptnDt") val recptnDt: String?=null,
    @Json( name = "rowNum") val rowNum: Int?=null,
    @Json(name ="selectedCount") val selectedCount: Int?=null,
    @Json(name ="statnFid") val statnFid: String?=null,
    @Json(name ="statnId") val statnId: String?=null,
    @Json(name ="statnList") val statnList: String?=null,
    @Json(name ="statnNm") val statnNm: String?=null,
    @Json(name ="statnTid") val statnTid: String?= null,
    @Json(name ="subwayHeading") val subwayHeading: String?= null,
    @Json(name ="subwayId") val subwayId: String? = null,
    @Json(name ="subwayList") val subwayList: String? = null,
    @Json(name ="subwayNm") val subwayNm: Any? = null,
    @Json(name ="totalCount") val totalCount: Int? = null,
    @Json(name ="trainCo") val trainCo: Any? = null,
    @Json(name ="trainLineNm") val trainLineNm: String,
    @Json(name ="updnLine") val updnLine: String?= null
) {
    fun toSmallData() : SubwayArrivalSmallData{
        return SubwayArrivalSmallData(bstatnNm,barvlDt.toInt(),arvlMsg2,trainLineNm)
    }
}