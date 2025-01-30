package com.example.speedyserve.Navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.speedyserve.auth.Login.LoginScreen
import com.example.speedyserve.auth.SignUp.SignUpScreen

@Composable
fun SpeedyServeNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController , startDestination = SpeedyServeScreens.LoginScreen.name) {
        composable(
            SpeedyServeScreens.LoginScreen.name,
            enterTransition = {
                fadeIn(animationSpec = tween(500)) // Bounce effect
            },
            exitTransition = {
                // Slide out to the left when exiting
                fadeOut(animationSpec = tween(500))
            }
        ){
            LoginScreen(navController = navController)
        }
        composable(SpeedyServeScreens.SignUpScreen.name,
            enterTransition = {
                fadeIn(animationSpec = tween(500))  // Bounce effect
            },
            exitTransition = {
                fadeOut(animationSpec = tween(500)) // Slide down when exiting
            }
        ){
            SignUpScreen(navController = navController)
        }
    }
}