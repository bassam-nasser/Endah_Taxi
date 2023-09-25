package com.megatrust.endahtaxi.screens.reg

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.megatrust.endahtaxi.R
import com.megatrust.endahtaxi.composable.InputTextField
import com.megatrust.endahtaxi.composable.TextHeader
import com.megatrust.endahtaxi.ui.theme.BlackTaxi
import com.megatrust.endahtaxi.ui.theme.tajwalFamily
import com.megatrust.endahtaxi.viewmodel.RegisterViewModel

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun RegisterScreenContent() {

    val context = LocalContext.current

    var name by remember { mutableStateOf("") }

    val viewModel: RegisterViewModel by viewModel()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xffFCFCFC)),
    ) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth()) {
            TextHeader()
        }

        Box(
            contentAlignment = Alignment.Center, modifier = Modifier
                .padding(top = 63.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = context.getString(R.string.createAccount),
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 24.sp, color = BlackTaxi,
                    fontFamily = tajwalFamily,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                ),
                color = BlackTaxi,
                textAlign = TextAlign.Center
            )
        }

        Column(modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.height(43.dp))

            InputTextField(
                context.getString(R.string.name),
                query = viewModel.driverState.value.name,
                onQueryChanged = {
                    viewModel.updateName(it)
                })

            InputTextField(context.getString(R.string.phoneNumber),
                query = viewModel.driverState.value.phoneNumber,
                onQueryChanged = {
                    viewModel.updatePhone(it)
                })

            InputTextField(context.getString(R.string.type),
                query = viewModel.driverState.value.carType,
                onQueryChanged = {
                    viewModel.updateType(it)
                })

            InputTextField(context.getString(R.string.model),
                query = viewModel.driverState.value.carModel,
                onQueryChanged = {
                    viewModel.updateModel(it)
                })


        }

    }

}


@Preview
@Composable
fun RegisterScreenContentPreview() {
    RegisterScreenContent()
}