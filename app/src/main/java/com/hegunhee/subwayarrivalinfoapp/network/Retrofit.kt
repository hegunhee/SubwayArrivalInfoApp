package com.hegunhee.subwayarrivalinfoapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


fun getSubwayInfoApi() : SubwayInfoApi = Retrofit.Builder()
    .baseUrl(SUBWAY_INFO_BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()
    .create(SubwayInfoApi::class.java)


const val SUBWAY_INFO_BASE_URL = "http://openapi.seoul.go.kr:8088"