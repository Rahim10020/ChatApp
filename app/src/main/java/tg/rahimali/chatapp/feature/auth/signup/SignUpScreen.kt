package tg.rahimali.chatapp.feature.auth.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import tg.rahimali.chatapp.R
import tg.rahimali.chatapp.feature.auth.components.MyTextField


@Composable
@Preview
fun SignUpScreenPreview(){
    SignUpScreen(navController = rememberNavController())
}


@Composable
fun SignUpScreen(navController: NavController) {

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }



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
                stringResource(R.string.name),
                painterResource(R.drawable.ic_person),
                name,
                false
            ) { newName -> name = newName }

            Spacer(modifier = Modifier.height(4.dp))

            MyTextField(
                stringResource(R.string.email),
                painterResource(R.drawable.ic_email),
                email,
                false
            ) { newEmail -> email = newEmail }

            Spacer(modifier = Modifier.height(4.dp))

            MyTextField(
                stringResource(R.string.password),
                painterResource(R.drawable.ic_lock),
                password,
                true
            ) { newPassword -> password = newPassword }

            Spacer(modifier = Modifier.height(4.dp))

            MyTextField(
                stringResource(R.string.confirm_password),
                painterResource(R.drawable.ic_lock),
                confirmPassword,
                true
            ) { newConfirmPassword -> confirmPassword = newConfirmPassword }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {}
            ) {
                Text(text = stringResource(R.string.sign_up_btn))
            }

            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = stringResource(R.string.sign_in),
            )
        }

    }
}