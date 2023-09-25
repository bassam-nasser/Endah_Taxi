package com.megatrust.endahtaxi.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.megatrust.endahtaxi.R
import com.megatrust.endahtaxi.ui.theme.BlackTaxi
import com.megatrust.endahtaxi.ui.theme.YellowDark

@Composable
fun TextHeader() {
    val context = LocalContext.current

    Row(
        horizontalArrangement = Arrangement.Center
    ) {

        Box(modifier = Modifier.padding(top = 63.dp)) {
            Card(
                shape = RoundedCornerShape(4.dp),
                colors = CardDefaults.cardColors(containerColor = BlackTaxi)
            ) {
                Text(
                    text = context.getString(R.string.taxi),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 32.sp, color = YellowDark
                    ),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .width(160.dp)
                        .height(64.dp)
                )
            }
        }



        Box(modifier = Modifier.padding(top = 63.dp)) {
            Card(
                shape = RoundedCornerShape(4.dp),
                colors = CardDefaults.cardColors(containerColor = YellowDark)
            ) {
                Text(
                    text = context.getString(R.string.endah),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 32.sp, color = BlackTaxi
                    ),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .width(160.dp)
                        .height(64.dp)
                )
            }
        }
    }
}