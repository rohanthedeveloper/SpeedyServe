package com.example.speedyserve.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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