package com.megatrust.endahtaxi.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.megatrust.endahtaxi.ui.theme.BlackTaxi
import com.megatrust.endahtaxi.ui.theme.YellowDark
import com.megatrust.endahtaxi.ui.theme.YellowNormal

@Composable
fun BodyBackground(
    screenWidthAverage: Dp,
    screenHeightAverage: Dp
) {
    Row(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.height(15.dp))
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .size(width = screenWidthAverage, height = screenHeightAverage)
                .background(YellowNormal)
        ) {

        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .size(width = screenWidthAverage, height = screenHeightAverage)
                .background(BlackTaxi)
        ) {

        }
    }
}