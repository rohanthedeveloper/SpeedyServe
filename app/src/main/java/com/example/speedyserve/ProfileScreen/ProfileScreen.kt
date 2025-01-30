package com.example.speedyserve.ProfileScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
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
        topBar = { DetailsTopBar() },
        bottomBar = { BottomNavigationBar() },
    ) { paddingValues ->
        Surface(color = Color(0xFFECEFF1)) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
                    .fillMaxSize()
                    .statusBarsPadding().padding(paddingValues)
            ) {
                Spacer(modifier = Modifier.height(6.dp))
            }
        }
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
                    "Details",
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
