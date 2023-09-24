package com.megatrust.endahtaxi.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
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
fun HeaderSplit(screenWidthAverage: Dp) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(4.dp)
    ) {
        Box(
            modifier = Modifier
                .size(screenWidthAverage)
                .background(BlackTaxi)
        ) {

        }
        Box(
            modifier = Modifier
                .size(screenWidthAverage)
                .background(YellowDark)
        ) {

        }
    }
}

