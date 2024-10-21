package com.ganesh.unitconverterjetpack

import com.ganesh.unitconverterjetpack.compose.BaseScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.ganesh.unitconverterjetpack.ui.theme.UnitConverterJetpackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UnitConverterJetpackTheme {
                BaseScreen()
            }
        }
    }
}