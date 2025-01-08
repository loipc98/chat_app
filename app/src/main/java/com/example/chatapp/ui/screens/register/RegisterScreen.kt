package com.example.chatapp.ui.screens.register

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.chatapp.R
import com.example.chatapp.ui.custom.CustomOutlineTextField
import com.example.chatapp.ui.custom.CustomTextButton
import com.example.chatapp.ui.theme.NormalImageColor
import com.example.chatapp.ui.theme.NormalTextColor
import com.example.chatapp.ui.theme.getLoginLogoutBackground

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    navigateToLoginScreen: () -> Unit
) {
    var avatarUri by remember {
        mutableStateOf<Uri?>(null)
    }
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        avatarUri = uri
    }

    Scaffold(
        modifier = Modifier.fillMaxSize().background(Color.Green),
        containerColor = getLoginLogoutBackground(),
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = getLoginLogoutBackground(),
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Row(
                        modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            modifier = Modifier.clickable{
                                navigateToLoginScreen()
                            },
                            text = "Back",
                            color = NormalTextColor,
                            fontSize = 16.sp,
                            style = MaterialTheme.typography.bodySmall,
                        )
                        Image(
                            modifier = Modifier.padding(end = 16.dp).size(60.dp),
                            painter = painterResource(R.drawable.tiger_icon),
                            contentDescription = stringResource(R.string.tiger_image),
                            colorFilter = ColorFilter.tint(color = NormalImageColor)
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(top = 16.dp),
                text = "Create a new account",
                color = NormalTextColor,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
            )
            if(avatarUri == null)
            Icon(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .size(80.dp),
                imageVector = Icons.Filled.AccountCircle,
                contentDescription = "Face Icon",
                tint = Color.White
            )
            else {
                AsyncImage(
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .size(80.dp)
                        .clip(CircleShape)
                        .border(width = 2.dp, color = Color.Gray, shape = CircleShape)
                        .background(Color.Black),
                    model = avatarUri,
                    contentScale = ContentScale.Crop,
                    contentDescription = "This is avatar"
                )
            }
            Text(
                modifier = Modifier.padding(top = 8.dp).clickable {
                    launcher.launch("image/*")
                },
                text = "Choose a profile picture",
                color = NormalTextColor,
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.Bold,
            )
            CustomOutlineTextField(
                modifier = Modifier.padding(top = 16.dp, bottom = 8.dp, start = 24.dp, end = 24.dp),
                label = "Email"
            )
            CustomOutlineTextField(
                modifier = Modifier.padding(vertical = 8.dp, horizontal = 24.dp),
                label = "Username"
            )
            CustomOutlineTextField(
                modifier = Modifier.padding(vertical = 8.dp, horizontal = 24.dp),
                label = "Password"
            )
            CustomOutlineTextField(
                modifier = Modifier.padding(vertical = 8.dp, horizontal = 24.dp),
                label = "Confirm Password"
            )
            CustomTextButton(
                text = "Register",
                onClick = {}
            )
        }
    }
}

@Preview
@Composable
fun RegisterScreenReview() {
    RegisterScreen {  }
}