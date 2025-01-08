package com.example.chatapp.ui.screens.listchat

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chatapp.ui.theme.NormalTextColor
import com.example.chatapp.ui.theme.SelectedContainerDrawer
import com.example.chatapp.ui.theme.getDrawerContainerBackground
import com.example.chatapp.ui.theme.getLoginLogoutBackground
import kotlinx.coroutines.launch

@Composable
fun ListChatScreen() {
    val drawerState  = rememberDrawerState(
        initialValue = DrawerValue.Closed
    )
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                drawerContainerColor = getDrawerContainerBackground()
            ) {
                DrawerContent()
            }
        },
        gesturesEnabled = true
    ) {
        Scaffold(
            topBar = {
                TopBar(
                    onOpenDrawer = {
                        scope.launch {
                            drawerState.apply {
                                if (isClosed) open() else close()
                            }
                        }
                    },
                )
            }
        ) { paddingValues ->
            ScreenContent(modifier = Modifier.padding(paddingValues))
        }
    }
}

@Composable
fun DrawerContent(modifier: Modifier = Modifier) {
    Text(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable{

            },
        text = "Chat App",
        color = NormalTextColor,
        style = MaterialTheme.typography.titleLarge,
    )

    HorizontalDivider(color = Color.White)
    Spacer(modifier = Modifier.height(8.dp))

    NavigationDrawerItem(
        icon = {
            Icon(
                imageVector = Icons.Rounded.AccountCircle,
                contentDescription = "Account",
                modifier = Modifier.padding(end = 8.dp).size(32.dp),
                tint = Color.White
            )
        },
        label = {
            Text(
                text = "Account",
                color = NormalTextColor,
                style = MaterialTheme.typography.bodyMedium,
            )
        },
        selected = true,
        onClick = {},
        colors = NavigationDrawerItemDefaults.colors(
            unselectedContainerColor = Color.Transparent,
            selectedContainerColor = SelectedContainerDrawer
        )
    )

    NavigationDrawerItem(
        icon = {
            Icon(
                imageVector = Icons.Rounded.AccountCircle,
                contentDescription = "Account",
                modifier = Modifier.padding(end = 8.dp).size(32.dp),
                tint = Color.White
            )
        },
        label = {
            Text(
                text = "Account",
                color = NormalTextColor,
                style = MaterialTheme.typography.bodyMedium,
            )
        },
        selected = false,
        onClick = {},
        colors = NavigationDrawerItemDefaults.colors(
            unselectedContainerColor = Color.Transparent,
            selectedContainerColor = SelectedContainerDrawer
        )
    )
}

@Preview(showSystemUi = true)
@Composable
fun DrawerContentPreview() {
    ModalDrawerSheet(
        drawerContainerColor = getDrawerContainerBackground()
    ) {
        DrawerContent()
    }
}

@Composable
fun ScreenContent(modifier: Modifier  =Modifier) {

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    onOpenDrawer: () -> Unit
) {
    TopAppBar(
        navigationIcon = {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Menu",
                modifier = Modifier
                    .padding(start = 16.dp, end = 8.dp)
                    .size(28.dp)
                    .clickable {
                    onOpenDrawer()
                },
                tint = Color.White
            )
        },
        colors = topAppBarColors(
            containerColor = getLoginLogoutBackground(),
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        title = {

        },
        actions = {
            Text(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .clickable{

                    },
                text = "Sign Out",
                color = NormalTextColor,
                fontSize = 16.sp,
                style = MaterialTheme.typography.bodySmall,
            )
        }
    )
}

@Preview
@Composable
fun ListChatScreenPreview() {
    ListChatScreen()
}