package tg.rahimali.chatapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import tg.rahimali.chatapp.feature.auth.signin.LoginScreen
import tg.rahimali.chatapp.feature.auth.signup.SignUpScreen
import tg.rahimali.chatapp.feature.home.HomeScreen

@Composable
fun MainApp(){
    Surface(modifier = Modifier.fillMaxSize()) {
        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = "login") {
            composable("login"){
                LoginScreen(navController)
            }
            composable("register"){
                SignUpScreen(navController)
            }
            composable("home"){
                HomeScreen(navController)
            }
        }
    }
}