package tg.rahimali.chatapp.feature.auth.signin

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import tg.rahimali.chatapp.R
import tg.rahimali.chatapp.feature.auth.components.MyButton
import tg.rahimali.chatapp.feature.auth.components.MyTextField


@Composable
@Preview
fun LoginScreenPreview() {
    LoginScreen(navController = rememberNavController())
}


@Composable
fun LoginScreen(navController: NavController) {
    val viewModel: SignInViewModel = hiltViewModel()
    // mis a jour automatique du ui en fonction des changements d'etats
    val uiState = viewModel.state.collectAsState()

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val context = LocalContext.current
    LaunchedEffect(key1 = uiState.value) {

    }

    Scaffold(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(it)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(R.drawable.chat),
                contentDescription = null,
                modifier = Modifier.size(80.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))

            MyTextField(
                stringResource(R.string.email),
                painterResource(R.drawable.ic_email),
                email,
                transformation = false,
                isError = false,
            ) { newEmail -> email = newEmail }

            Spacer(modifier = Modifier.height(4.dp))

            MyTextField(
                stringResource(R.string.password),
                painterResource(R.drawable.ic_lock),
                password,
                transformation = true,
                isError = false,
            ) { newPassword -> password = newPassword }

            Spacer(modifier = Modifier.height(20.dp))

            if (uiState.value == SignInState.Loading) {
                CircularProgressIndicator()
            } else {
                MyButton(
                    stringResource(R.string.login_btn),
                    enabled = email.isNotEmpty() && password.isNotEmpty() && uiState.value == SignInState.Nothing || uiState.value == SignInState.Error,
                    onClick = { viewModel.signIn(email, password) }
                )
            }
            Spacer(modifier = Modifier.height(10.dp))

            TextButton(
                onClick = { navController.navigate("register") }
            ) {
                Text(
                    text = stringResource(R.string.sign_up),
                    fontSize = 16.sp
                )
            }
        }

    }
}