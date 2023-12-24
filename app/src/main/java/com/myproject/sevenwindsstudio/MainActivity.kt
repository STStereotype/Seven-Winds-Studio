package com.myproject.sevenwindsstudio

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.myproject.sevenwindsstudio.navigation.NavGraphTabs
import com.myproject.sevenwindsstudio.navigation.mainGraph
import com.myproject.sevenwindsstudio.ui.theme.MainTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("DEBUG_CHECK", "onCreate")
        setContent {
            val navController = rememberNavController()
            MainTheme {
                NavHost(
                    navController = navController,
                    startDestination = NavGraphTabs.Main.route
                ) {
                    mainGraph(navController = navController)
                }
            }
        }
    }
}
