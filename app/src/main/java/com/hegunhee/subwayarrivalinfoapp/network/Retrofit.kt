package com.hegunhee.subwayarrivalinfoapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


fun getSubwayInfoApi() : SubwayInfoApi = Retrofit.Builder()
    .baseUrl(SUBWAY_INFO_BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()
    .create(SubwayInfoApi::class.java)

fun getSubwayArrivalApi() : SubwayArrivalApi = Retrofit.Builder()
    .baseUrl(SUBWAY_ARRIVAL_BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()
    .create(SubwayArrivalApi::class.java)


const val SUBWAY_INFO_BASE_URL = "http://openapi.seoul.go.kr:8088"

const val SUBWAY_ARRIVAL_BASE_URL = "http://swopenapi.seoul.go.kr/api/subway/"