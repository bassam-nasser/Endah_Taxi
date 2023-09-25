package com.megatrust.endahtaxi.screens.reg

import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.megatrust.endahtaxi.R
import com.megatrust.endahtaxi.composable.InputTextField
import com.megatrust.endahtaxi.composable.TextHeader
import com.megatrust.endahtaxi.ui.theme.BlackTaxi
import com.megatrust.endahtaxi.ui.theme.tajwalFamily
import com.megatrust.endahtaxi.utill.Existent
import com.megatrust.endahtaxi.utill.RegisterValidation
import com.megatrust.endahtaxi.utill.checkDriverData
import com.megatrust.endahtaxi.viewmodel.RegisterViewModel

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun RegisterScreenContent(
    navController: NavController,
    viewModel: RegisterViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

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
                }
            )
        }

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

            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Button(
                    onClick = {
//                        viewModel.checkIfExistentBefore(viewModel.driverState.value.phoneNumber)
                        when (val validation = checkDriverData(viewModel.driverState.value)) {

                            is RegisterValidation.Failed -> {
                                Toast.makeText(context, validation.message, Toast.LENGTH_SHORT)
                                    .show()
                            }

                            is RegisterValidation.Success -> {
                                viewModel.createDriver(viewModel.driverState.value)
                            }
                        }

                    },
                    modifier = Modifier
                        .padding(vertical = 16.dp)
                        .fillMaxWidth()
                        .height(48.dp)
                        .clip(RoundedCornerShape(8.dp))
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

            LaunchedEffect(key1 = viewModel.creationStatus.value) {
                viewModel.creationStatus.observe(lifecycleOwner) { existant ->
                    when (existant) {
                        Existent.EXIST -> {
                            Toast.makeText(context, "Exist", Toast.LENGTH_LONG).show()
                        }

                        Existent.NOT_EXIST -> {
                            Toast.makeText(context, "NOT_EXIST", Toast.LENGTH_LONG).show()
                        }

                        Existent.CREATED -> {
                            Log.d("TAGG5", "CREATED")
                            navController.navigate("SuccessScreen")
                        }

                        Existent.Failed -> {
                            Toast.makeText(context, "Failed", Toast.LENGTH_LONG).show()

                        }
                    }
                }
            }

        }

    }

}
