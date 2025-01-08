package com.example.chatapp.navigation

import androidx.navigation.NavHostController
import com.example.chatapp.utils.Contains.ALL_CHAT_SCREEN
import com.example.chatapp.utils.Contains.LOGIN_SCREEN
import com.example.chatapp.utils.Contains.REGISTER_SCREEN

class Screens(navHostController: NavHostController) {
    val navigateToLoginScreen: () -> Unit = {
        navHostController.navigate(route = LOGIN_SCREEN) {

        }
    }
    val navigateToRegisterScreen: () -> Unit = {
        navHostController.navigate(route = REGISTER_SCREEN) {

        }
    }

    val navigateToAllChatScreen: () -> Unit = {
        navHostController.navigate(route = ALL_CHAT_SCREEN) {

        }
    }
}