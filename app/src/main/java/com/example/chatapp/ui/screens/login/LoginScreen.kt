package com.example.chatapp.ui.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chatapp.R
import com.example.chatapp.ui.custom.CustomOutlineTextField
import com.example.chatapp.ui.custom.CustomTextButton
import com.example.chatapp.ui.theme.NormalImageColor
import com.example.chatapp.ui.theme.NormalTextColor
import com.example.chatapp.ui.theme.getLoginLogoutBackground

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navigateToRegisterScreen: () -> Unit,
    navigateToAllChatScreen: () -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize().background(Color.Green),
        containerColor = getLoginLogoutBackground(),
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = getLoginLogoutBackground(),
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {},
                actions = {
                    Text(
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .clickable{
                            navigateToRegisterScreen()
                        },
                        text = "Register",
                        color = NormalTextColor,
                        fontSize = 16.sp,
                        style = MaterialTheme.typography.bodySmall,
                    )
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier.padding(horizontal = 75.dp),
                painter = painterResource(R.drawable.tiger_icon),
                contentDescription = stringResource(R.string.tiger_image),
                colorFilter = ColorFilter.tint(color = NormalImageColor)
            )
            Text(
                text = "Login to your account",
                color = NormalTextColor,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
            )
            CustomOutlineTextField(
                modifier = Modifier.padding(top = 16.dp, bottom = 8.dp, start = 24.dp, end = 24.dp),
                label = "Email"
            )
            CustomOutlineTextField(
                modifier = Modifier.padding(vertical = 8.dp, horizontal = 24.dp),
                label = "Password"
            )
            Column(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp),
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    "Forgot Password?",
                    color = NormalTextColor,
                    fontSize = 14.sp,
                    style = MaterialTheme.typography.labelSmall,
                    fontWeight = FontWeight.Bold
                )
            }
            CustomTextButton(
                text = "Sign In",
                onClick = {
                    navigateToAllChatScreen()
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(
        navigateToRegisterScreen = {},
        navigateToAllChatScreen = {}
    )
}