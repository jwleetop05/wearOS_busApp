package com.example.realbustime.presentation.models

import com.google.gson.annotations.SerializedName

data class BusIdAndStationId(
    @SerializedName("bus") val bus: List<BusId>,
    @SerializedName("stop") val station: List<StationId>
)
data class BusId(
    @SerializedName("bus_name") val bus_name: String,
    @SerializedName("route_id") val route_id: Int
)
data class StationId(
    @SerializedName("stop_id") val stop_id: Int,
    @SerializedName("ars_id") val ars_id: Int,
    @SerializedName("Stop_name") val Stop_name: String,
    @SerializedName("x") val x: Int,
    @SerializedName("y") val y: Int,
)