package com.megatrust.endahtaxi.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.megatrust.endahtaxi.R
import com.megatrust.endahtaxi.ui.theme.BlackTaxi
import com.megatrust.endahtaxi.ui.theme.YellowDark
import com.megatrust.endahtaxi.ui.theme.YellowNormal

@Composable
fun BodyBackground(
    screenWidthAverage: Dp,
    screenHeightAverage: Dp
) {
    val context = LocalContext.current
    Column {

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
                    .background(YellowNormal)
            ) {

            }
        }

        //background

        Row(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        ) {

            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .size(width = screenWidthAverage, height = screenHeightAverage)
                    .background(YellowNormal), contentAlignment = Alignment.TopEnd
            ) {

                Box(modifier = Modifier.padding(top = 100.dp)) {
                    Card(
                        shape = RoundedCornerShape(4.dp),
                        colors = CardDefaults.cardColors(containerColor = BlackTaxi)
                    ) {
                        Text(
                            text = context.getString(R.string.taxi),
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontSize = 32.sp, color = YellowNormal
                            ),
                            modifier = Modifier.padding(horizontal = 32.dp)
                        )
                    }
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .size(width = screenWidthAverage, height = screenHeightAverage)
                    .background(BlackTaxi)
            ) {

                Box(modifier = Modifier.padding(top = 100.dp)) {
                    Card(
                        shape = RoundedCornerShape(4.dp),
                        colors = CardDefaults.cardColors(containerColor = YellowNormal)
                    ) {
                        Text(
                            text = context.getString(R.string.endah),
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontSize = 32.sp, color = BlackTaxi
                            ),
                            modifier = Modifier.padding(horizontal = 32.dp)
                        )
                    }
                }
            }
        }
    }

}