package com.megatrust.endahtaxi.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.megatrust.endahtaxi.R
import com.megatrust.endahtaxi.composable.BodyBackground
import com.megatrust.endahtaxi.ui.theme.BlackTaxi
import com.megatrust.endahtaxi.ui.theme.YellowNormal

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenContent(navController: NavController) {
    val configuration = LocalConfiguration.current
    val context = LocalContext.current

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

            Spacer(modifier = Modifier.height(200.dp))

            Image(
                painter = painterResource(id = R.drawable.l_car),
                contentDescription = "App logo",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(100.dp))

            Card(
                modifier = Modifier.shadow(20.dp, RoundedCornerShape(16.dp)),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = YellowNormal),
                onClick = {
                    navController.navigate("RegisterScreen")
                }
            ) {
                Text(
                    text = context.getString(R.string.register),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 24.sp, color = BlackTaxi, fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.padding(horizontal = 32.dp, vertical = 16.dp)
                )
            }

        }
    }
}


@Composable
@Preview
fun HomeScreenPreview() {
}
