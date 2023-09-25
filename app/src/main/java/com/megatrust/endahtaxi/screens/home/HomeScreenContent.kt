package com.megatrust.endahtaxi.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.megatrust.endahtaxi.R
import com.megatrust.endahtaxi.composable.BodyBackground
import com.megatrust.endahtaxi.ui.theme.BlackTaxi
import com.megatrust.endahtaxi.ui.theme.tajwalFamily

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

            Box(
                Modifier
                    .padding(top = 16.dp, start = 16.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.TopStart
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = "back button",
                    modifier = Modifier.clickable {
                    }
                )
            }

            Spacer(modifier = Modifier.height(200.dp))

            Image(
                painter = painterResource(id = R.drawable.l_car),
                contentDescription = "App logo",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(100.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Button(
                    onClick = { navController.navigate("RegisterScreen") },
                    modifier = Modifier
                        .padding(vertical = 16.dp)
                        .fillMaxWidth()
                        .height(48.dp)
                        .clip(RoundedCornerShape(4.dp))
                ) {
                    Text(
                        text = context.getString(R.string.createAccount),
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontSize = 16.sp, color = BlackTaxi,
                            fontFamily = tajwalFamily,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold
                        ),
                        color = BlackTaxi,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }

        }
    }
}


@Composable
@Preview
fun HomeScreenPreview() {
}
