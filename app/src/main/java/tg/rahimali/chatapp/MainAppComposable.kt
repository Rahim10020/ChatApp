package tg.rahimali.chatapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import tg.rahimali.chatapp.feature.auth.signin.LoginScreen
import tg.rahimali.chatapp.feature.auth.signup.SignUpScreen
import tg.rahimali.chatapp.feature.home.HomeScreen

@Composable
fun MainApp(){
    Surface(modifier = Modifier.fillMaxSize()) {
        val navController = rememberNavController()
        var startDestination by remember { mutableStateOf("login") }

        LaunchedEffect(Unit) {
            val user = FirebaseAuth.getInstance().currentUser
            if (user != null) {
                startDestination = "home"
            }
        }

        NavHost(navController = navController, startDestination = startDestination) {
            composable("login") { LoginScreen(navController) }
            composable("register") { SignUpScreen(navController) }
            composable("home") { HomeScreen(navController) }
        }
    }
}