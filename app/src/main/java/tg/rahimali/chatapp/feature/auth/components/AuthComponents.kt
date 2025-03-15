package tg.rahimali.chatapp.feature.auth.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import tg.rahimali.chatapp.R


@Composable
fun MyTextField(
    label: String,
    painter: Painter,
    value: String,
    transformation: Boolean,
    onValueChange: (String) -> Unit
) {

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = value,
        onValueChange = { onValueChange(it) },
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
            focusedContainerColor = colorResource(R.color.colorVertBack),
            unfocusedContainerColor = colorResource(R.color.colorTextWhite),
            cursorColor = colorResource(R.color.colorTextBlack),
            focusedLabelColor = colorResource(R.color.colorTextBlack),
            unfocusedLabelColor = colorResource(R.color.colorTextBlack),
            unfocusedBorderColor = Color.Transparent,
            focusedBorderColor = Color.Transparent
        ),
        visualTransformation = if (transformation) PasswordVisualTransformation() else VisualTransformation.None,
        singleLine = true,
        shape = RoundedCornerShape(10.dp),
    )
}