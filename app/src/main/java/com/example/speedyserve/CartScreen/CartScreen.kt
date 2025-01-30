package com.example.speedyserve.CartScreen

import android.media.Rating
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.speedyserve.Components.BottomNavigationBar
import com.example.speedyserve.ProfileScreen.SettingsSection
import com.example.speedyserve.ProfileScreen.UserInfoSection
import com.example.speedyserve.R
import com.example.speedyserve.data.Dish
import com.example.speedyserve.data.dishesList
import com.google.accompanist.systemuicontroller.rememberSystemUiController


@Preview
@Composable
fun CartScreen() {
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setSystemBarsColor(
            color = Color(0xFFECEFF1),
            darkIcons = true
        )
    }
    Scaffold(
        modifier = Modifier.background(color = Color(0xFFECEFF1)),
        topBar = { CartTopBar() },
    ) { paddingValues ->
        Surface(color = Color(0xFFECEFF1)) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
                    .fillMaxSize()
                    .statusBarsPadding().padding(paddingValues)
            ) {
                Spacer(modifier = Modifier.height(6.dp))
                CartScreenContent(dishes = dishesList)
            }
        }
    }
}

@Composable
fun CartScreenContent(dishes : List<Dish>){
    var scrollState = rememberScrollState()
    Column(modifier = Modifier.fillMaxSize().verticalScroll(scrollState)) {
        LazyColumn(
            modifier = Modifier.fillMaxSize().weight(1f),
            contentPadding = PaddingValues(horizontal = 16.dp,),
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
        BillSummary()
        androidx.compose.material.Button(
            onClick = {/* include the logic for timeslot*/},
            modifier = Modifier.fillMaxWidth().height(50.dp).padding(start = 40.dp, end = 40.dp)
                .background(
                    brush = Brush.radialGradient(
                        colors = listOf(Color(0xFFFF9800), Color(0xFF995B00)),
                        center = androidx.compose.ui.geometry.Offset(0f, 0f),
                        radius = 400f
                    ),
                    shape = RoundedCornerShape(12.dp)
                ),
            colors = ButtonDefaults.buttonColors(Color.Transparent),
            elevation = ButtonDefaults.elevation(0.dp)
        ) {
            Text(
                text = "Select Time Slot",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFFFFFFF),
                )
            )
        }

    }
}

@Composable
fun BillSummary(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .background(Color.White, shape = RoundedCornerShape(12.dp))
            .padding(16.dp)
    ) {
        Text("To Pay" , fontSize = 18.sp , fontWeight = FontWeight.SemiBold)
        BillRow("1 shevbhaji", Price = "₹42.00")
        BillRow("1 Paneer Rice", Price = "₹42.00")
        BillRow("1 Chapati", Price = "₹42.00")
        Divider(modifier = Modifier.padding(vertical = 8.dp))
        BillRow("Total" , Price = "125" , isBold = true )

    }
}

@Composable
fun BillRow(
    label: String,
    Price: String,
    isBold: Boolean = false,
    isGreen: Boolean = false,
    isClickable: Boolean = false
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            fontSize = 14.sp,
            fontWeight = if (isBold) FontWeight.Bold else FontWeight.Normal
        )

        Row {
            Text(
                text = Price,
                fontSize = 14.sp,
                fontWeight = if (isBold) FontWeight.Bold else FontWeight.Normal,
                color = when {
                    isGreen -> Color(0xFF4CAF50) // Green color for FREE
                    isClickable -> Color(0xFFFF5722) // Orange color for clickable "Add a tip"
                    else -> Color.Black
                }
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartTopBar(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .background(color = Color(0xFFECEFF1)),
    ) {
        CenterAlignedTopAppBar(modifier = Modifier.background(color = Color(0xFFECEFF1)),
            title = {
                Text(
                    "My Cart",
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
fun DishCard(name : String  , rating: Int , price : Int ){
    Surface(modifier = Modifier.padding(horizontal = 20.dp).fillMaxWidth() , shape = RoundedCornerShape(12.dp)) {
        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            Column(modifier = Modifier.padding(horizontal = 12.dp)) {
                Spacer(modifier = Modifier.height(12.dp))
                Text(name, fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
                Spacer(modifier = Modifier.height(12.dp))
                Row() {
                    repeat(rating) {
                        Text(text = "★", color = Color(0xFF000000), fontSize = 16.sp)
                    }
                }
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    "Rs${price}",
                    fontSize = 14.sp,
                    color = Color(0xFF777777),
                    fontWeight = FontWeight.SemiBold
                )
            }
            Column(verticalArrangement = Arrangement.Center , horizontalAlignment = Alignment.CenterHorizontally) {
                Image(painter = painterResource(R.drawable.paneer_image), contentDescription = null, modifier = Modifier.padding(12.dp))
                Button(
                    onClick = { /* Handle Remove action */ },
                    modifier = Modifier
                        .padding(8.dp),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(text = "Remove")
                }
            }
        }
    }
}