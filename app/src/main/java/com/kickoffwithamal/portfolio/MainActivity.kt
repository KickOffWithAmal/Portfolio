package com.kickoffwithamal.portfolio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kickoffwithamal.portfolio.screens.InspireScreen
import com.kickoffwithamal.portfolio.screens.SplashScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        setContent {
//            PortfolioTheme {
//                AppEntry()
////                InspireScreen()
//            }
//        }

        
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "splash") {
                composable("splash") {
                    SplashScreen(navController = navController)
                }
                composable("inspire") {
                    InspireScreen()
                }
            }
        }
    }
}