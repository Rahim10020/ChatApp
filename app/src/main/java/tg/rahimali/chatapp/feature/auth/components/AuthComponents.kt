package tg.rahimali.chatapp.feature.auth.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import tg.rahimali.chatapp.R

@Composable
fun MyEmailTextField(label: String, painter: Painter){
    var email by remember { mutableStateOf("") }

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = email,
        onValueChange = {email = it},
        label = {
            Text(text = label)
        },
        leadingIcon = {
            Icon(
                painter = painter,
                contentDescription = null,
                tint = colorResource(R.color.colorBlack)
            )
        },
        visualTransformation = VisualTransformation.None,
        keyboardOptions = KeyboardOptions.Default,
        singleLine = true,
        shape = RoundedCornerShape(10.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = colorResource(R.color.colorTextBlack),
            focusedContainerColor = colorResource(R.color.colorWhite),
            unfocusedContainerColor = colorResource(R.color.colorTextWhite),
            cursorColor = colorResource(R.color.colorTextBlack),
            focusedLabelColor = colorResource(R.color.colorTextBlack),
            unfocusedLabelColor = colorResource(R.color.colorTextBlack),
            unfocusedBorderColor = Color.Transparent,
            focusedBorderColor = Color.Transparent
        )
    )
}


@Composable
fun MyNameTextField(label: String, painter: Painter){
    var name by remember { mutableStateOf("") }

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = name,
        onValueChange = {name = it},
        label = {
            Text(text = label)
        },
        leadingIcon = {
            Icon(
                painter = painter,
                contentDescription = null,
                tint = colorResource(R.color.colorBlack)
            )
        },
        visualTransformation = VisualTransformation.None,
        keyboardOptions = KeyboardOptions.Default,
        singleLine = true,
        shape = RoundedCornerShape(10.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = colorResource(R.color.colorTextBlack),
            focusedContainerColor = colorResource(R.color.colorWhite),
            unfocusedContainerColor = colorResource(R.color.colorTextWhite),
            cursorColor = colorResource(R.color.colorTextBlack),
            focusedLabelColor = colorResource(R.color.colorTextBlack),
            unfocusedLabelColor = colorResource(R.color.colorTextBlack),
            unfocusedBorderColor = Color.Transparent,
            focusedBorderColor = Color.Transparent
        )
    )
}


@Composable
fun MyPasswordTextField(label: String, painter: Painter){
    var password by remember { mutableStateOf("") }

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = password,
        onValueChange = {password = it},
        label = {
            Text(text = label)
        },
        leadingIcon = {
            Icon(
                painter = painter,
                contentDescription = null,
                tint = colorResource(R.color.colorBlack)
            )
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = colorResource(R.color.colorTextBlack),
            focusedContainerColor = colorResource(R.color.colorWhite),
            unfocusedContainerColor = colorResource(R.color.colorTextWhite),
            cursorColor = colorResource(R.color.colorTextBlack),
            focusedLabelColor = colorResource(R.color.colorTextBlack),
            unfocusedLabelColor = colorResource(R.color.colorTextBlack),
            unfocusedBorderColor = Color.Transparent,
            focusedBorderColor = Color.Transparent
        ),
        visualTransformation = PasswordVisualTransformation(),
        singleLine = true,
        shape = RoundedCornerShape(10.dp),
    )
}


@Composable
fun MyConfirmPasswordTextField(label: String, painter: Painter){
    var confirmPassword by remember { mutableStateOf("") }

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = confirmPassword,
        onValueChange = {confirmPassword = it},
        label = {
            Text(text = label)
        },
        leadingIcon = {
            Icon(
                painter = painter,
                contentDescription = null,
                tint = colorResource(R.color.colorBlack)
            )
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = colorResource(R.color.colorTextBlack),
            focusedContainerColor = colorResource(R.color.colorWhite),
            unfocusedContainerColor = colorResource(R.color.colorTextWhite),
            cursorColor = colorResource(R.color.colorTextBlack),
            focusedLabelColor = colorResource(R.color.colorTextBlack),
            unfocusedLabelColor = colorResource(R.color.colorTextBlack),
            unfocusedBorderColor = Color.Transparent,
            focusedBorderColor = Color.Transparent
        ),
        visualTransformation = PasswordVisualTransformation(),
        singleLine = true,
        shape = RoundedCornerShape(10.dp),
    )
}