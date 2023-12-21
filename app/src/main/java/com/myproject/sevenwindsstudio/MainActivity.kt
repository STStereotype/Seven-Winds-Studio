package com.myproject.sevenwindsstudio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.myproject.sevenwindsstudio.ui.theme.SevenwindsstudioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SevenwindsstudioTheme {
            }
        }
    }
}
