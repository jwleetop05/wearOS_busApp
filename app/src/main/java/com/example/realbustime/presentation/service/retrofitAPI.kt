package com.example.realbustime.presentation.service

import com.example.realbustime.presentation.models.BusIdAndStationId
import com.example.realbustime.presentation.models.BusRouteAll
import com.example.realbustime.presentation.models.BusRouteStationAll
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface retrofitAPI {
    @GET("getArrInfoByRouteAll")
    fun getBusRoute(@Query("ServiceKey") serviceKey: String, @Query("busRouteId") busRouteId: String, @Query("resultType") resultType:String): Call<BusRouteAll>
    @GET("getArrInfoByRoute")
    fun getBusRouteStation(@Query("ServiceKey") serviceKey: String, @Query("busRouteId") busRouteId: String, @Query("resultType") resultType:String, @Query("stId") stId:String, @Query("ord") ord:String): Call<BusRouteStationAll>
    @GET("/work")
    fun getBusIdAndStationId(): Call<BusIdAndStationId>
}