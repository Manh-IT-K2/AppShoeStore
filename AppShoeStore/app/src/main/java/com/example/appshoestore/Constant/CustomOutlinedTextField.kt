package com.example.appshoestore.Constant

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CustomOutlinedTextField(
    title: String,
    value: String,
    modifier: Modifier
) {
    var text by remember { mutableStateOf(value) }

    OutlinedTextField(
        value = text,
        onValueChange = { newText -> text = newText },
        label = { Text(title, color = Color.Blue.copy(alpha = 0.3f)) },
        modifier = modifier,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Color.Blue,
            focusedBorderColor = Color.Blue.copy(alpha = 0.3f),
            unfocusedBorderColor = Color.Blue.copy(alpha = 0.3f),
            backgroundColor = Color.Transparent
        ),
        textStyle = TextStyle(color = Color.Blue.copy(alpha = 0.5f))
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewCustomOutlinedTextField() {
    CustomOutlinedTextField(
        title = "Card Number", value = "8764 3421 0967 4738", modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
}