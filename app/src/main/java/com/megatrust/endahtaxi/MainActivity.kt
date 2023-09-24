package com.megatrust.endahtaxi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.megatrust.endahtaxi.app.EndahApp
import com.megatrust.endahtaxi.ui.theme.EndahTaxiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EndahTaxiTheme {
                EndahApp()
        }
    }
}

}