package com.example.speedyserve.Navigation

enum class SpeedyServeScreens {
    Splashscreen,
    LoginScreen,
    SignUpScreen,
    HomeScreen,
    ProfileScreen,
    UploadScreen,
    SearchScreen;

    companion object{
        fun fromRoute(route:String?) : SpeedyServeScreens = when(route?.substringBefore("/")){
            Splashscreen.name -> Splashscreen
            LoginScreen.name -> LoginScreen
            SignUpScreen.name -> SignUpScreen
            HomeScreen.name -> HomeScreen
            ProfileScreen.name -> ProfileScreen
            UploadScreen.name -> UploadScreen
            SearchScreen.name -> SearchScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("route $route not found")
        }
    }
}