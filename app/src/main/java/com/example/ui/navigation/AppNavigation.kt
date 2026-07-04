package com.example.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ui.screens.HomeScreen
import com.example.ui.screens.ServicesScreen
import com.example.ui.screens.BookingScreen
import com.example.ui.screens.BookingConfirmationScreen

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Services : Screen("services")
    object Booking : Screen("booking/{serviceId}") {
        fun createRoute(serviceId: String) = "booking/$serviceId"
    }
    object BookingConfirmation : Screen("booking_confirmation")
}

@Composable
fun AppNavigation(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier.fillMaxSize()
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                onNavigateToServices = { navController.navigate(Screen.Services.route) },
                onBookService = { serviceId -> 
                    navController.navigate(Screen.Booking.createRoute(serviceId))
                }
            )
        }
        composable(Screen.Services.route) {
            ServicesScreen(
                onBack = { navController.popBackStack() },
                onBookService = { serviceId ->
                    navController.navigate(Screen.Booking.createRoute(serviceId))
                }
            )
        }
        composable(Screen.Booking.route) { backStackEntry ->
            val serviceId = backStackEntry.arguments?.getString("serviceId") ?: ""
            BookingScreen(
                serviceId = serviceId,
                onBack = { navController.popBackStack() },
                onBookingComplete = { 
                    navController.navigate(Screen.BookingConfirmation.route) {
                        popUpTo(Screen.Home.route)
                    }
                }
            )
        }
        composable(Screen.BookingConfirmation.route) {
            BookingConfirmationScreen(
                onNavigateHome = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Home.route) { inclusive = true }
                    }
                }
            )
        }
    }
}
