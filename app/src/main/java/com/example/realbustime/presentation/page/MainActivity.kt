/* While this template provides a good starting point for using Wear Compose, you can always
 * take a look at https://github.com/android/wear-os-samples/tree/main/ComposeStarter and
 * https://github.com/android/wear-os-samples/tree/main/ComposeAdvanced to find the most up to date
 * changes to the libraries and their usages.
 */
// adb connect 10.246.158.225:5555 워치앱
package com.example.realbustime.presentation.page

import android.app.RemoteInput
import android.content.Intent
import android.graphics.drawable.shapes.Shape
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.wear.compose.material.Chip
import androidx.wear.compose.material.Text
import androidx.wear.input.RemoteInputIntentHelper
import androidx.wear.input.wearableExtender
import com.example.realbustime.presentation.theme.RealBusTimeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "home") {
                composable("home") { BusAPP(navController) }
                composable("search") { BusSearchPage(navController)}
                composable("searchDetail/{busid}") {
                    it.arguments?.getString("busid")
                        ?.let { it1 -> busDataDetail(it1,navController)}
                }
            }
        }
    }
}
@Composable
fun BusAPP(navController: NavHostController) {
    RealBusTimeTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 30.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
                serachBus(navController)
                MyBusList(navController)
            }
        }
    }
@Composable
fun serachBus(navController: NavHostController) {
    Box(Modifier.fillMaxWidth(0.8f).clickable { navController.navigate("search") }) {
        Text(text = "버스 입력하기")
    }
}
@Composable
fun MyBusList(navController: NavHostController) {
    LazyColumn(
        Modifier
            .fillMaxWidth()
            .height(500.dp)) {

    }
}