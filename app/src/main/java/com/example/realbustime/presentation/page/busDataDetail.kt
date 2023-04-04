package com.example.realbustime.presentation.page

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import com.example.realbustime.presentation.models.BusRouteAll
import com.example.realbustime.presentation.service.getJSONBusRouteAll
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch


@Composable
fun busDataDetail(bus_route_id: String, navController: NavHostController) {
    val busDataList = remember {
        mutableStateListOf<BusRouteAll?>()
    }
    val scope = MainScope()
    DisposableEffect(0) {
        scope.launch {
            while (true) {
                getJSONBusRouteAll(busDataList, bus_route_id)
            }
        }
        onDispose {
            scope.cancel()
        }
    }
    LazyColumn() {
        items(busDataList.toList()) { busRoute ->
            if (busRoute == null) {
                Text(text = "버스 정보를 불러오지 못했습니다")
            } else {
                busRoute.msgBody["itemList"]?.map { busData ->

                }
            }
        }
    }
}