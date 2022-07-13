package com.hegunhee.subwayarrivalinfoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.hegunhee.subwayarrivalinfoapp.network.SubwayInfoApi
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.awaitResponse
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var infoApi : SubwayInfoApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        GlobalScope.launch(Dispatchers.IO) {
            infoApi.getSubwayInfo(BuildConfig.SUBWAY_INFO_API_KEY).awaitResponse().body()?.run {
                searchInfoBySubwayNameService.row.let {
                    Log.d("ApiTest",it.toString())
                }
            }
        }
    }
}