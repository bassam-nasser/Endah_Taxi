package com.megatrust.endahtaxi.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.megatrust.endahtaxi.ui.theme.BlackTaxi
import com.megatrust.endahtaxi.ui.theme.tajwalFamily

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun InputTextField(
    label: String,
    query: String = "",
    validCharNumber: Int? = null,
    onQueryChanged: (String) -> Unit,
) {
    var textState by remember { mutableStateOf(query) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 18.dp),
        contentAlignment = Alignment.CenterEnd
    ) {
        Text(
            text = label, style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = BlackTaxi
            )
        )
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp)
    ) {
        OutlinedTextField(
            value = textState,
            onValueChange = {
                if (validCharNumber != null) {
                    if (it.length < validCharNumber) {
                        onQueryChanged(it)
                        textState = it
                    }
                } else {
                    onQueryChanged(it)
                    textState = it
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 6.dp, horizontal = 6.dp),
            textStyle = TextStyle(
                fontSize = 16.sp, color = BlackTaxi,
                fontFamily = tajwalFamily,
                textDirection = TextDirection.Rtl,
                fontWeight = FontWeight.Normal,
            ),
            shape = RoundedCornerShape(8.dp),
            singleLine = true,
            colors = TextFieldDefaults.outlinedTextFieldColors(textColor = Color(0xff606060))
        )
    }
}