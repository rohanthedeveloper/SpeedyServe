package com.example.speedyserve.auth.SignUp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.R
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.speedyserve.Navigation.SpeedyServeScreens
import com.example.speedyserve.auth.Components.RoundedTextField
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun SignUpScreen(modifier: Modifier = Modifier , navController: NavController){
    val systemUiController = rememberSystemUiController()
    // Set it to your desired color

    systemUiController.setStatusBarColor(
        color = Color(0xFFECEFF1),
        darkIcons = false // Use `true` for dark icons (light status bar)
    )
    systemUiController.setNavigationBarColor(
        color = Color(0xFFECEFF1)
    )
    var username by remember{
        mutableStateOf("")
    }
    var email by remember{
        mutableStateOf("")
    }
    var password by remember{
        mutableStateOf("")
    }
    var confirmPassword by remember{
        mutableStateOf("")
    }
    Column(
        modifier = Modifier.fillMaxSize().background(color = Color(0xFFECEFF1)),
        // verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Spacer(modifier = Modifier.height(90.dp))
        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Welcome to" , fontSize = 14.sp  , fontWeight = FontWeight.SemiBold)
            Text(text = "SpeedyServe" , fontSize = 32.sp , color = Color(0xFFFF9800), fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 12.dp))
        }
        Spacer(modifier = Modifier.height(50.dp))
        Text("SignUp" , fontSize = 18.sp , fontWeight = FontWeight.Bold ,
            modifier = Modifier.padding(start = 38.dp, end = 286.dp)
        )
        Spacer(modifier = Modifier.height(25.dp))
        RoundedTextField(value = username , onValueChange = {username = it} , placeHolderText = "Username" , singleLine = true, modifier = Modifier.padding(start = 40.dp , end = 40.dp) , isPasswordTextField = false )
        Spacer(modifier = Modifier.height(25.dp))
        RoundedTextField(value = email , onValueChange = {email = it} , placeHolderText = "Email" , singleLine = true, modifier = Modifier.padding(start = 40.dp , end = 40.dp) , isPasswordTextField = false )
        Spacer(modifier = Modifier.height(25.dp))
        RoundedTextField(value = password , onValueChange = {password = it} , placeHolderText = "Password" , singleLine = true, modifier = Modifier.padding(start = 40.dp , end = 40.dp) , isPasswordTextField = true )
        Spacer(modifier = Modifier.height(25.dp))
        RoundedTextField(value = confirmPassword , onValueChange = {confirmPassword = it} , placeHolderText = "Confirm Password" , singleLine = true, modifier = Modifier.padding(start = 40.dp , end = 40.dp) , isPasswordTextField = true )
        Spacer(modifier = Modifier.height(25.dp))
        Button(onClick = {},
            modifier = Modifier.fillMaxWidth().height(50.dp).padding(start = 40.dp , end = 40.dp).background(
                brush = Brush.radialGradient(
                    colors = listOf(Color(0xFFFF9800), Color(0xFF995B00)),
                    center = androidx.compose.ui.geometry.Offset(0f, 0f), // Gradient center
                    radius = 400f // Radius of the gradient
                ),
                shape = RoundedCornerShape(12.dp) // Rounded corners
            ),
            colors = ButtonDefaults.buttonColors(Color.Transparent),
        ) {
            Text(
                text = "SignUp",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFFFFFFF),
                ) )
        }
        Spacer(modifier = Modifier.height(25.dp))
        Text("Already have an account? Login" , modifier = Modifier.clickable { navController.navigate(SpeedyServeScreens.LoginScreen.name) } , fontSize = 14.sp  , fontWeight = FontWeight.Medium , color = Color(0xFFFF9800))
    }
}

@Preview
@Composable
fun SignUpPreview() {
    SignUpScreen(navController = rememberNavController())
}