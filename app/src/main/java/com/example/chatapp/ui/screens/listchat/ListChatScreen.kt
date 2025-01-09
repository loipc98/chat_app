package com.example.chatapp.ui.screens.listchat

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chatapp.R
import com.example.chatapp.ui.theme.BorderAvatarColor
import com.example.chatapp.ui.theme.ChatDividerColor
import com.example.chatapp.ui.theme.FloatActionButtonColor
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

    // hardCodeChat:
    val messages = listOf(
        MessageData(avatar = "", latestString = "Hello", sender = "Jack"),
        MessageData(avatar = "", latestString = "Have a nice day", sender = "Kotlin"),
        MessageData(avatar = "", latestString = "Good morning", sender = "Android"),
    )

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
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {},
                    containerColor = FloatActionButtonColor,
                    contentColor = Color.White,
                ) {
                    Icon(
                        Icons.Filled.Add,
                        contentDescription = "Add"
                    )
                }
            }
        ) { paddingValues ->
            ScreenContent(modifier = Modifier.padding(paddingValues), messages)
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
                imageVector = Icons.Rounded.Email,
                contentDescription = "Latest Messages",
                modifier = Modifier.padding(end = 8.dp).size(32.dp),
                tint = Color.White
            )
        },
        label = {
            Text(
                text = "Latest Messages",
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
fun ScreenContent(modifier: Modifier  =Modifier, messages: List<MessageData>) {
    LazyColumn(modifier = modifier) {
        items(messages) { message ->
            MessageItem(message)
            HorizontalDivider(modifier = Modifier.height(1.dp), color = ChatDividerColor)
        }
    }
}

@Composable
fun MessageItem(messageData: MessageData) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painterResource(R.drawable.tiger_icon),
            modifier = Modifier
                .padding(8.dp)
                .size(48.dp)
                .clip(CircleShape)
                .border(width = 2.dp, color = BorderAvatarColor, shape = CircleShape),
            contentDescription = ""
        )
        Column(modifier = Modifier.padding(vertical = 8.dp).fillMaxWidth()) {
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = messageData.sender,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = messageData.latestString,
                fontWeight = FontWeight.Normal,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

data class MessageData(
    val avatar: String,
    val latestString: String,
    val sender: String,
)

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
            Text(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .clickable{

                    },
                text = "Latest Messages",
                fontWeight = FontWeight.Bold,
                color = NormalTextColor,
                fontSize = 18.sp,
                style = MaterialTheme.typography.bodyLarge,
            )
        },
        actions = {
            Text(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .clickable{

                    },
                text = "SIGN OUT",
                color = NormalTextColor,
                fontSize = 14.sp,
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