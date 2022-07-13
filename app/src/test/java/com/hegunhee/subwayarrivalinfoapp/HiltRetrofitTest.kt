package com.hegunhee.subwayarrivalinfoapp

import com.hegunhee.subwayarrivalinfoapp.network.SubwayInfoApi
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.awaitResponse
import javax.inject.Inject

@HiltAndroidTest
class HiltRetrofitTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var infoApi : SubwayInfoApi

    @Before
    fun init() {
        hiltRule.inject()
    }

    @Test
    fun `get Data`() = runBlocking{
        launch(Dispatchers.IO) {
            infoApi.getSubwayInfo(BuildConfig.SUBWAY_INFO_API_KEY).awaitResponse().body()?.run {
                this.searchInfoBySubwayNameService.row.let {
                    println(it)
                }
            }
        }.join()
    }
}