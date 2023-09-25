package com.megatrust.endahtaxi.screens.successscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.megatrust.endahtaxi.R
import com.megatrust.endahtaxi.ui.theme.BlackTaxi
import com.megatrust.endahtaxi.ui.theme.tajwalFamily

@Composable
fun SuccessScreenContent(navController: NavController) {

    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xffFCFCFC)),
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
                    navController.navigate("HomeScreen")
                }
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 110.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_succes_icon),
                contentDescription = "",
                modifier = Modifier
                    .height(120.dp)
                    .width(120.dp),
                contentScale = ContentScale.Crop
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = context.getString(R.string.successMessage),
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 24.sp, color = BlackTaxi,
                    fontFamily = tajwalFamily,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = context.getString(R.string.thanksMessage),
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 16.sp, color = Color(0xFF606060),
                    fontFamily = tajwalFamily,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Normal
                )
            )
        }
        Spacer(modifier = Modifier.height(220.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Button(
                onClick = {
                    navController.navigate("HomeScreen")
                },
                modifier = Modifier
                    .padding(vertical = 16.dp)
                    .fillMaxWidth()
                    .height(48.dp)
                    .clip(RoundedCornerShape(4.dp))
            ) {
                Text(
                    text = context.getString(R.string.start),
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


@Composable
@Preview
fun HomeScreenPreview() {
//    SuccessScreenContent()
}
