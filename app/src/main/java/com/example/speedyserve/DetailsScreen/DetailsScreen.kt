package com.example.speedyserve.DetailsScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.speedyserve.HomeScreen.CanteenCard
import com.example.speedyserve.HomeScreen.CanteenList
import com.example.speedyserve.HomeScreen.HomeTopBar
import com.example.speedyserve.HomeScreen.SearchBar
import com.example.speedyserve.R
import com.example.speedyserve.data.Canteen
import com.example.speedyserve.data.Dish
import com.example.speedyserve.data.canteenList
import com.example.speedyserve.data.dishesList
import com.example.speedyserve.ui.theme.Pacifico
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun DetailsScreen(){
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
        bottomBar = { com.example.speedyserve.HomeScreen.BottomNavigationBar() },
    ) { paddingValues ->
        Surface(color = Color(0xFFECEFF1)) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
                    .fillMaxSize()
                    .statusBarsPadding().padding(paddingValues)
            ) {
                Spacer(modifier = Modifier.height(6.dp))
                DetailsScreenContent()
            }
        }
    }
}

@Composable
fun DetailsScreenContent() {
    Column(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.padding(start = 20.dp)){
            Text("VIIT College Canteen", fontSize = 24.sp , fontWeight = FontWeight.Bold)
            Text("opening time: 9:30am" , fontSize = 12.sp , fontWeight = FontWeight.SemiBold , color = Color(0xFF777777))
            Text("closing time: 6:00pm" , fontSize = 12.sp , fontWeight = FontWeight.SemiBold,color = Color(0xFF777777))
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text("Available dishes", fontSize = 14.sp , fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(start = 20.dp))
        DishList(dishes = dishesList)
    }
}
@Composable
fun DishList(dishes: List<Dish>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(dishes) { dish ->
            DishCard(
                name = dish.name,
                rating = dish.rating,
                price = dish.price
            )
        }
    }
}
@Composable
fun DishCard(name: String,
             rating: Int,
             price: Int, ) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.padding(20.dp).fillMaxWidth()
    ) {
        Column {
            // Dish Image
            Box {
                Image(
                    painter = painterResource(id = R.drawable.paneer_image), // Replace with actual image resource
                    contentDescription = "Paneer Rice",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)),
                    contentScale = ContentScale.Crop
                )

                // Price Tag
                Text(
                    text = "Rs${price}",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.padding(end = 8.dp)
                        .background(Color.White.copy(alpha = 1f), RoundedCornerShape(12.dp))
                        .align(Alignment.TopEnd)
                        .padding(4.dp)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

           Row(horizontalArrangement = Arrangement.SpaceBetween) {
               Column() {
                   Text(
                       text = name,
                       fontSize = 16.sp,
                       fontWeight = FontWeight.Bold,
                       modifier = Modifier.padding(horizontal = 12.dp)
                   )

                   Spacer(modifier = Modifier.height(4.dp))

                   // Rating
                   Row(modifier = Modifier.padding(horizontal = 12.dp)) {
                       repeat(rating) {
                           Text(text = "★", color = Color(0xFFFFD700), fontSize = 16.sp)
                       }
                   }
               }
               Button(
                   onClick = { /* Handle Add action */ },
                   modifier = Modifier
                       .padding(8.dp),
                   shape = RoundedCornerShape(12.dp)
               ) {
                   Text(text = "Add")
               }
           }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsTopBar(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .background(color = Color(0xFFECEFF1)),
    ) {
        TopAppBar(modifier = Modifier.background(color = Color(0xFFECEFF1)),
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

@Preview
@Composable
fun DetailsPreview(){
    DetailsScreen()
}