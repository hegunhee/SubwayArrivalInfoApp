package com.hegunhee.subwayarrivalinfoapp

import com.hegunhee.subwayarrivalinfoapp.Util.subway_line_limit
import com.hegunhee.subwayarrivalinfoapp.data.entity.SubwayInfoEntity
import com.hegunhee.subwayarrivalinfoapp.network.getSubwayInfoApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Test
import retrofit2.awaitResponse
import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis

class SubwayInfoRetrofitUnitTest {

    @Test
    fun `test Retrofit`() = runBlocking {
        launch(Dispatchers.IO) {
            println("start")
            val api = getSubwayInfoApi()
            println("api start")
            api.getSubwayInfo(BuildConfig.SUBWAY_INFO_API_KEY).awaitResponse().body()?.run {
                println(this.searchInfoBySubwayNameService.result.code)

                println(this.searchInfoBySubwayNameService.row.toString())
            }
        }.join()
    }

    @Test
    fun `test mapping subwayInfoEntity`() = runBlocking {
        launch(Dispatchers.IO) {
            println("start")
            val api = getSubwayInfoApi()
            println("api start")
            api.getSubwayInfo(BuildConfig.SUBWAY_INFO_API_KEY).awaitResponse().body()?.run {
                searchInfoBySubwayNameService.row.let {
                    println(it.groupBy { it.station_nm }.map { subway ->
                        SubwayInfoEntity(subway.key, subway.value.map { if(it.line_num[0] == '0') {it.line_num.substring(1)} else{it.line_num }})
                    })
                }
            }

        }.join()
    }

    @Test
    fun `test subwayLine Color`() = runBlocking {
        launch(Dispatchers.IO) {
            getSubwayInfoApi().getSubwayInfo(BuildConfig.SUBWAY_INFO_API_KEY).awaitResponse().body()?.run {
                searchInfoBySubwayNameService.row.let {
                    println(it.map { if(it.line_num[0] == '0') {it.line_num.substring(1)} else it.line_num}.filter { it in subway_line_limit }.distinct())
                }
            }

        }.join()
    }

    @Test
    fun `get one to nine line Entity`() = runBlocking {
        launch(Dispatchers.IO) {
            getSubwayInfoApi().getSubwayInfo(BuildConfig.SUBWAY_INFO_API_KEY).awaitResponse().body()?.run {
                searchInfoBySubwayNameService.row.let {
                    it.filter { it.station_nm in subway_line_limit }.groupBy { it.station_nm }.map { subway ->
                        SubwayInfoEntity(subway.key,subway.value.map{it.line_num.substring(1)})
                    }.let {
                        println(it)
                    }
                }
            }
        }.join()
    }


}