package com.hegunhee.subwayarrivalinfoapp

import com.hegunhee.subwayarrivalinfoapp.network.getSubwayArrivalApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import retrofit2.awaitResponse

class SubwayArrivalRetrofitUnitTest {

    @Test
    fun `get Json Data`()= runBlocking{
        launch(Dispatchers.IO) {
            println("start")
            val api = getSubwayArrivalApi()
            println("api start")
            val what = api.getSubwayInfo(key = BuildConfig.SUBWAY_ARRIVAL_API_KEY, station_nm = "계양").awaitResponse().body()?.run {
                println(errorMessage.code)
                println(realtimeArrivalList.toString())
            }
            println("end")
        }.join()

        val str = "부평행 어쩌구행".substring(0,"부평행 어쩌구저쩌구행".indexOf("행"))
        println(str)
    }

    @Test
    fun `jsonData to SmallData`() = runBlocking {
        launch(Dispatchers.IO) {
            getSubwayArrivalApi().getSubwayInfo(key = BuildConfig.SUBWAY_ARRIVAL_API_KEY, station_nm = "강남").awaitResponse().body()?.run {
                realtimeArrivalList.map { it.toSmallData() }.let {
                    println(it)
                }
            }

        }.join()
    }
}