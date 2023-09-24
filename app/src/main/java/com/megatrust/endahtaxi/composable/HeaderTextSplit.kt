package com.megatrust.endahtaxi.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.megatrust.endahtaxi.R
import com.megatrust.endahtaxi.ui.theme.BlackTaxi
import com.megatrust.endahtaxi.ui.theme.YellowDark

@Composable
fun HeaderTextSplit() {


        Card(
            shape = RoundedCornerShape(4.dp),
            colors = CardDefaults.cardColors(containerColor = YellowDark)
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
@Composable
@Preview
fun HeaderTextSplitPrev() {
    HeaderTextSplit()
}