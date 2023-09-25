package com.megatrust.endahtaxi.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.megatrust.endahtaxi.composable.BodyBackground

@Composable
fun HomeScreen() {
    val configuration = LocalConfiguration.current

    val screenHeightAverage = configuration.screenHeightDp.dp
    val screenWidthAverage = configuration.screenWidthDp.dp / 2

    Box {

        BodyBackground(
            screenWidthAverage = screenWidthAverage,
            screenHeightAverage = screenHeightAverage
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


        }
    }
}


@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen()
}
