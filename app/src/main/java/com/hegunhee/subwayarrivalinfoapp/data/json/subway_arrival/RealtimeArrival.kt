package com.hegunhee.subwayarrivalinfoapp.data.json.subway_arrival


import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RealtimeArrival(
    @field:Json(name = "arvlCd")
    val arvlCd: String,
    @field:Json(name = "arvlMsg2")
    val arvlMsg2: String,
    @field:Json(name = "arvlMsg3")
    val arvlMsg3: String,
    @field:Json(name = "barvlDt")
    val barvlDt: String,
    @field:Json(name = "beginRow")
    val beginRow: Any,
    @field:Json(name ="bstatnId")
    val bstatnId: String,
    @field:Json(name = "bstatnNm")
    val bstatnNm: String,
    @field:Json(name = "btrainNo")
    val btrainNo: String,
    @field:Json(name = "btrainSttus")
    val btrainSttus: Any,
    @field:Json(name ="curPage")
    val curPage: Any,
    @field:Json(name ="endRow")
    val endRow: Any,
    @field:Json(name = "ordkey")
    val ordkey: String,
    @field:Json(name ="pageRow")
    val pageRow: Any,
    @field:Json(name ="recptnDt")
    val recptnDt: String,
    @field:Json( name = "rowNum")
    val rowNum: Int,
    @field:Json(name ="selectedCount")
    val selectedCount: Int,
    @field:Json(name ="statnFid")
    val statnFid: String,
    @field:Json(name ="statnId")
    val statnId: String,
    @field:Json(name ="statnList")
    val statnList: String,
    @field:Json(name ="statnNm")
    val statnNm: String,
    @field:Json(name ="statnTid")
    val statnTid: String,
    @field:Json(name ="subwayHeading")
    val subwayHeading: String,
    @field:Json(name ="subwayId")
    val subwayId: String,
    @field:Json(name ="subwayList")
    val subwayList: String,
    @field:Json(name ="subwayNm")
    val subwayNm: Any,
    @field:Json(name ="totalCount")
    val totalCount: Int,
    @field:Json(name ="trainCo")
    val trainCo: Any,
    @field:Json(name ="trainLineNm")
    val trainLineNm: String,
    @field:Json(name ="updnLine")
    val updnLine: String
) {
    fun toSmallData() : SubwayArrivalSmallData{
        return SubwayArrivalSmallData(bstatnNm,barvlDt.toInt(),arvlMsg2,trainLineNm)
    }
}