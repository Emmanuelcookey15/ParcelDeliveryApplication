package com.example.parceldeliveryapp.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
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
        composable<ScreenA>(
            enterTransition = {
                return@composable fadeIn(tween(1000))
            }, exitTransition = {
                return@composable fadeOut(tween(700))
            }, popEnterTransition = {
                return@composable slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.End, tween(700)
                )
            }
        ) {
            BottomNavScreen(navController, trackingInformations[0])
        }
        composable<ScreenB>(
            enterTransition = {
                return@composable fadeIn(tween(1000))
            }, exitTransition = {
                return@composable slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Start, tween(700)
                )
            }, popEnterTransition = {
                return@composable slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.End, tween(700)
                )
            }
        ) {
            MoveMateScreen(navController)
        }
        composable<ScreenC>(
            enterTransition = {
                return@composable fadeIn(tween(1000))
            }, exitTransition = {
                return@composable fadeOut(tween(700))
            }, popEnterTransition = {
                return@composable slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.End, tween(700)
                )
            }
        ) {
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