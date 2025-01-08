package com.example.chatapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val LightBlue = Color(0xFF65C365)
val DarkPurple = Color(0xFF301934)

val BlueTransparent = Color(0x110000FF)

@Composable
fun getLoginLogoutBackground() = if(isSystemInDarkTheme()) DarkPurple else LightBlue

@Composable
fun getDrawerContainerBackground() = if(isSystemInDarkTheme()) DarkPurple else LightBlue

val SelectedContainerDrawer = BlueTransparent

val NormalTextColor = Color.White
val NormalImageColor = Color.White
val NormalOutlineTextColor = Color.White
val HintTextColor = Color(0xFFDEDEDE)
val TextButtonColor = LightBlue