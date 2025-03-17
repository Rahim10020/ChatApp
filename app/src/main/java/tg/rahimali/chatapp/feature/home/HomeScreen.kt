package tg.rahimali.chatapp.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
@Preview
fun HomeScreenPreview(){
    HomeScreen(navController = rememberNavController())
}


@Composable
fun HomeScreen(navController: NavController){
    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Red)
                .padding(it)
        ) {

        }
    }
}