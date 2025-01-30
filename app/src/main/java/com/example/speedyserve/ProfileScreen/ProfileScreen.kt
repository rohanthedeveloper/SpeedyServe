package com.example.speedyserve.ProfileScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.speedyserve.Components.BottomNavigationBar
import com.example.speedyserve.DetailsScreen.DetailsScreenContent
import com.example.speedyserve.DetailsScreen.DetailsTopBar
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun ProfileScreen() {
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setSystemBarsColor(
            color = Color(0xFFECEFF1),
            darkIcons = true
        )
    }
    Scaffold(
        modifier = Modifier.background(color = Color(0xFFECEFF1)),
        topBar = { ProfileTopBar() },
        bottomBar = { BottomNavigationBar() },
    ) { paddingValues ->
        Surface(color = Color(0xFFECEFF1)) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
                    .fillMaxSize()
                    .statusBarsPadding().padding(paddingValues)
            ) {
                Spacer(modifier = Modifier.height(6.dp))
                UserInfoSection()
                Spacer(modifier = Modifier.height(20.dp))
                SettingsSection()
                Button(onClick = {},
                    modifier = Modifier.fillMaxWidth().height(50.dp).padding(start = 20.dp , end = 20.dp).background(
                        brush = Brush.radialGradient(
                            colors = listOf(Color(0xFFFF9800), Color(0xFF995B00)),
                            center = androidx.compose.ui.geometry.Offset(0f, 0f), // Gradient center
                            radius = 400f // Radius of the gradient
                        ),
                        shape = RoundedCornerShape(12.dp) // Rounded corners
                    ),
                    colors = ButtonDefaults.buttonColors(Color.Transparent),
                    elevation = ButtonDefaults.elevation(0.dp)
                ) {
                    Text(
                        text = "Logout",
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFFFFFFF),
                        ) )
                }
            }
        }
    }
}

@Composable
fun UserInfoSection() {
    Row(
        modifier = Modifier.padding(horizontal = 20.dp).fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text("Meet Oza", fontSize = 22.sp, fontWeight = FontWeight.Bold)
            Text("ozameet300905@gmail.com", fontSize = 16.sp, color = Color.Red)
        }
        IconButton(onClick = { /* Handle Edit Click */ }) {
            Icon(Icons.Filled.Edit, contentDescription = "Edit Profile", tint = Color(0xFFFF5722))
        }
    }
}
@Composable
fun SettingsSection() {
    Column {
        Text("Settings", fontSize = 18.sp, fontWeight = FontWeight.Bold , modifier = Modifier.padding(horizontal = 20.dp))

        Spacer(modifier = Modifier.height(8.dp))

        SettingsItem(title = "Orders", subtitle = "0 Items", isBoldSubtitle = true)
        SettingsItem(title = "Privacy Policy")
        SettingsItem(title = "Term & Condition")
        SettingsItem(title = "Support")
    }
}

@Composable
fun SettingsItem(title: String, subtitle: String? = null, isBoldSubtitle: Boolean = false) {
    Column(
        modifier = Modifier.padding(horizontal = 20.dp)
            .fillMaxWidth()
            .clickable { /* Handle Click */ }
            .padding(vertical = 12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(title, fontSize = 16.sp, fontWeight = FontWeight.Medium)
                subtitle?.let {
                    Text(
                        text = it,
                        fontSize = 14.sp,
                        color = Color.Red,
                        fontWeight = if (isBoldSubtitle) FontWeight.Bold else FontWeight.Normal
                    )
                }
            }
            Text(">", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.Gray)
        }
        Divider(color = Color.LightGray, thickness = 1.dp)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileTopBar(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .background(color = Color(0xFFECEFF1)),
    ) {
        CenterAlignedTopAppBar(modifier = Modifier.background(color = Color(0xFFECEFF1)),
            title = {
                Text(
                    "Profile",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                )
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color(0xFFECEFF1),
                titleContentColor = Color(0xFF000000)
            ),
            navigationIcon = {
                IconButton(onClick = { /* Handle notification click */ }) {
                    Icon(Icons.Filled.ArrowBackIosNew, contentDescription = "back")
                }
            }
        )
    }
}

@Preview
@Composable
fun ProfilePreview(){
    ProfileScreen()
}