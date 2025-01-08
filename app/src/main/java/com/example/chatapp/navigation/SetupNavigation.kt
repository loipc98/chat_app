package com.example.chatapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.chatapp.ui.screens.login.LoginScreen
import com.example.chatapp.ui.screens.register.RegisterScreen
import com.example.chatapp.utils.Contains.LOGIN_SCREEN
import com.example.chatapp.utils.Contains.REGISTER_SCREEN

@Composable
fun SetupNavigation(
    navHostController: NavHostController,
) {
    val screens = remember { Screens(navHostController) }

    NavHost(
        navController = navHostController,
        startDestination = LOGIN_SCREEN
    ) {
        composable(
            route = LOGIN_SCREEN,
        ) {
            LoginScreen(
                navigateToRegisterScreen = screens.navigateToRegisterScreen
            )
        }
        composable(
            route = REGISTER_SCREEN
        ) {
            RegisterScreen(
                navigateToLoginScreen = screens.navigateToLoginScreen
            )
        }
    }
}