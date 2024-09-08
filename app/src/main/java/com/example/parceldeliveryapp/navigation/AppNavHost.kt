package com.example.parceldeliveryapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.parceldeliveryapp.data.trackingInformations
import com.example.parceldeliveryapp.presentation.succes_screen.MoveMateScreen
import com.example.parceldeliveryapp.presentation.bottom_nav.BottomNavScreen
import com.example.parceldeliveryapp.presentation.home.SearchScreen
import com.example.parceldeliveryapp.presentation.home.model.TrackingInformation
import kotlinx.serialization.Serializable

@Composable
fun AppNavHost(
    navController: NavHostController,
    startDestination: Any,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
    ){
        composable<ScreenA> {
            BottomNavScreen(navController, trackingInformations[0])
        }
        composable<ScreenB> {
            MoveMateScreen(navController)
        }
        composable<ScreenC> {
            SearchScreen(navController)
        }
    }
}

@Serializable
object ScreenA

@Serializable
object ScreenB

@Serializable
object ScreenC