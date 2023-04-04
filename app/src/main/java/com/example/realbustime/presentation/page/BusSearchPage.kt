package com.example.realbustime.presentation.page

import android.app.RemoteInput
import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.wear.compose.material.*
import androidx.wear.input.RemoteInputIntentHelper
import androidx.wear.input.wearableExtender
import com.example.realbustime.presentation.models.BusIdAndStationId
import com.example.realbustime.presentation.service.getJSONBusIdAndStationId
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch


@Composable
fun BusSearchPage(navController: NavController) {
    val idList = remember {
        mutableStateListOf<BusIdAndStationId?>()
    }
    val scope = MainScope()
    DisposableEffect(0) {
        scope.launch {
            getJSONBusIdAndStationId(idList);
        }
        onDispose {
            scope.cancel()
        }
    }
    var searchText by remember {
        mutableStateOf("")
    }
    val launcher =
        rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            it.data?.let { data ->
                val results: Bundle = RemoteInput.getResultsFromIntent(data)
                val ipAddress: CharSequence? = results.getCharSequence("input_key")
                searchText = ipAddress as String
            }
        }
    val scalingLazyListState: ScalingLazyListState = rememberScalingLazyListState()
    ScalingLazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(6.dp),
        state = scalingLazyListState,
    ) {
        item {
            Chip(
                label = { Text("버스 번호 입력하기") },
                onClick = {
                    val intent: Intent = RemoteInputIntentHelper.createActionRemoteInputIntent();
                    val remoteInputs: List<RemoteInput> = listOf(
                        RemoteInput.Builder("input_key")
                            .setLabel("userInput")
                            .wearableExtender {
                                setEmojisAllowed(true)
                                setInputActionType(EditorInfo.IME_ACTION_DONE)
                            }.build()
                    )
                    RemoteInputIntentHelper.putRemoteInputsExtra(intent, remoteInputs)
                    launcher.launch(intent)
                }
            )
        }
        items(idList.toList()) { busData ->
            if(busData == null) {
                Text(text = "버스 데이터를 불러오는 중입니다.")
            } else {
                if(busData.bus.filter { it.bus_name.startsWith(searchText) }.isEmpty()) {
                    Text(text = "일치하는 버스가 없습니다.")
                } else {
                    busData.bus.filter { it.bus_name.startsWith(searchText) }.map { busId ->
                        Row(Modifier.clickable { navController.navigate("searchDetail/${busId.route_id}") }) {
                            Icon(imageVector = Icons.Default.Home, contentDescription = "버스")
                            Text(busId.bus_name)
                        }
                    }
                }
            }
        }
    }
}
