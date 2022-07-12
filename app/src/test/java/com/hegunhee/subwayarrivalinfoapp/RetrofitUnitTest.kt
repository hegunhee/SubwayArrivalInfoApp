package com.hegunhee.subwayarrivalinfoapp

import com.hegunhee.subwayarrivalinfoapp.network.getSubwayInfoApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Test
import retrofit2.awaitResponse
import kotlin.system.measureNanoTime

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
}