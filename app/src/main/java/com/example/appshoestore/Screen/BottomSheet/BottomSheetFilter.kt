package com.example.appshoestore.Screen.BottomSheet

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterAlt
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.material.rememberBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appshoestore.Screen.SearchScreen

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
fun BottomSheetFilter() {
    var showBottomSheet by remember { mutableStateOf(false) }
    val bottomSheetState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberBottomSheetState(
            initialValue = androidx.compose.material.BottomSheetValue.Collapsed
        )
    )

    // Function to toggle bottom sheet visibility
    val toggleBottomSheet = {
        showBottomSheet = true
    }

    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    val bottomSheetHeight = screenHeight - 150.dp

    // Rest of your BottomSheetScaffold setup
    BottomSheetScaffold(
        sheetShape = RoundedCornerShape(
            topStart = 50.dp,
            topEnd = 50.dp
        ),
        scaffoldState = bottomSheetState,
        sheetContent = {
            // Your bottom sheet content
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(bottomSheetHeight),
                elevation = 8.dp,
                shape = RoundedCornerShape(
                    topStart = 50.dp,
                    topEnd = 50.dp
                ),
                backgroundColor = Color.White

            ) {

            }
        },
        sheetPeekHeight = 0.dp
    ) {
        // Content of the screen where you want to display the bottom sheet trigger
        //SearchScreen()
//        Button(onClick = {
//            showBottomSheet = true
//        }) {
//            Text("Open Bottom Sheet")
//        }
    }

    // Handling bottom sheet state outside the scaffold
    if (showBottomSheet) {
        LaunchedEffect(bottomSheetState) {
            if (showBottomSheet) {
                bottomSheetState.bottomSheetState.expand()
                showBottomSheet = false // Reset state after expanding
            }
        }
    }
}
