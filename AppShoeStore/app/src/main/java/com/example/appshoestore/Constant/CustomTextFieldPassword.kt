package com.example.appshoestore.Constant

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CustomTextFieldPassword(
    value: String,
    onTextChange: (String) -> Unit,
    title: String,
    modifier: Modifier = Modifier
) {
    var isPasswordVisible by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = value,
        onValueChange = onTextChange,
        label = { Text(title, color = Color.Blue.copy(alpha = 0.3f)) },
        modifier = modifier,
        trailingIcon = {
            val image = if (isPasswordVisible)
                Icons.Filled.Visibility
            else
                Icons.Filled.VisibilityOff

            IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                Icon(
                    imageVector = image,
                    contentDescription = null,
                    tint = Color.Blue.copy(alpha = 0.3f)
                )
            }
        },
        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Color.Blue,
            focusedBorderColor = Color.Blue.copy(alpha = 0.3f),
            unfocusedBorderColor = Color.Blue.copy(alpha = 0.3f),
            backgroundColor = Color.Transparent
        ),
        textStyle = TextStyle(color = Color.Blue.copy(alpha = 0.5f))
    )
}

@Preview
@Composable
fun PreviewCustomTextFieldPassword() {
    var text by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp)
            .background(Color.White)
    ) {
        CustomTextFieldPassword(
            title = "Email Address",
            value = text,
            onTextChange = { text = it }
        )
    }
}