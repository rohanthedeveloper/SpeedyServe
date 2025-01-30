package com.example.speedyserve.HomeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.rounded.Home
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.speedyserve.R
import com.example.speedyserve.data.Canteen
import com.example.speedyserve.data.canteenList
import com.example.speedyserve.ui.theme.Pacifico
import com.google.accompanist.systemuicontroller.rememberSystemUiController


@Composable
fun HomeScreen() {
    var searchQuery by remember { mutableStateOf("") }
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setSystemBarsColor(
            color = Color(0xFFECEFF1),
            darkIcons = true
        )
    }
    Scaffold(
        modifier = Modifier.background(color = Color(0xFFECEFF1)),
        topBar = { HomeTopBar() },
        bottomBar = { BottomNavigationBar() },
    ) { paddingValues ->
        Surface(color = Color(0xFFECEFF1)) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
                    .fillMaxSize()
                    .statusBarsPadding().padding(paddingValues)
            ) {
                Spacer(modifier = Modifier.height(12.dp))
                SearchBar(query = searchQuery , onQueryChange = { searchQuery = it })
                CanteenList(canteens = canteenList)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .background(color = Color(0xFFECEFF1)),
    ) {
        TopAppBar(modifier = Modifier.background(color = Color(0xFFECEFF1)),
            title = {
                Text(
                    "SpeedyServe",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = Pacifico
                )
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color(0xFFECEFF1),
                titleContentColor = Color(0xFFFF9800)
            ),
            actions = {
                IconButton(onClick = { /* Handle notification click */ }) {
                    Icon(Icons.Filled.Notifications, contentDescription = "Notifications")
                }
            }
        )
    }
}

@Composable
fun BottomNavigationBar() {
    NavigationBar(
        containerColor = Color(0xFFFF9800), // Light blue color
        contentColor = Color(0xFF000000),
        modifier = Modifier
            .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)) // Apply rounded corners to top-left and top-right
            .fillMaxWidth()
            .background(color = Color(0xFFE3F2FD))// White content color
    ) {
        // Home Button
        NavigationBarItem(
            label = {
                Text(
                    "Home",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold
                )
            },
            selected = false,
            icon = {
                Icon(
                    imageVector = Icons.Rounded.Home,
                    contentDescription = "Rounded Home Icon",
                    modifier = Modifier
                        .height(30.dp)
                        .width(30.dp)
                )
            },
            onClick = { /* Navigate to Home */ }
        )

        NavigationBarItem(
            label = {
                Text(
                    "Cart",
                   // fontFamily = Montserrat,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold
                )
            },
            selected = false,
            icon = {
                Icon(
                    imageVector = Icons.Filled.ShoppingCart,
                    contentDescription = "History Icon",
                    modifier = Modifier
                        .height(30.dp)
                        .width(30.dp)
                )
            },
            onClick = { /* Navigate to History */ }
        )
        NavigationBarItem(
            label = {
                Text(
                    "Profile",
                    // fontFamily = Montserrat,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold
                )
            },
            selected = false,
            icon = {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = "History Icon",
                    modifier = Modifier
                        .height(30.dp)
                        .width(30.dp)
                )
            },
            onClick = { /* Navigate to History */ }
        )
    }
}
@Composable
fun CanteenList(canteens: List<Canteen>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(canteens) { canteen ->
            CanteenCard(
                name = canteen.name,
                openingTime = canteen.openingTime,
                closingTime = canteen.closingTime,
                isOpen = canteen.isOpen
            )
        }
    }
}
@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}