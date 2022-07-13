package com.hegunhee.subwayarrivalinfoapp

import com.hegunhee.subwayarrivalinfoapp.data.entity.SubwayInfoEntity
import com.hegunhee.subwayarrivalinfoapp.network.getSubwayInfoApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Test
import retrofit2.awaitResponse
import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis

class RetrofitUnitTest {

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
                        SubwayInfoEntity(subway.key, subway.value.map { it.line_num })
                    })
                }
            }

        }.join()
    }
}