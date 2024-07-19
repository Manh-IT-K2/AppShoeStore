package com.example.appshoestore.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appshoestore.R

@Preview
@Composable
fun OtpVerificationScreen() {
    var scrollState = rememberScrollState()
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(start = 22.dp, end = 22.dp)
            .verticalScroll(scrollState)
    )
    {
        Column {
            Spacer(modifier = Modifier.height(16.dp))
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.ArrowBackIos,
                    contentDescription = null,
                    tint = Color.Black
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Enter Verification Code",
                style = TextStyle(
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = "We have sent the code verification to your registered email address.",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Gray
                )
            )
            val code = remember { mutableStateOf(List(5) { "" }) }
            val focusRequesters = List(5) { FocusRequester() }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 22.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                for (i in code.value.indices) {
                    CodeInputBox(
                        value = code.value[i],
                        onValueChange = { newValue ->
                            if (newValue.length <= 1) {
                                code.value = code.value.toMutableList().apply { this[i] = newValue }
                                if (newValue.isNotEmpty() && i < code.value.size - 1) {
                                    focusRequesters[i + 1].requestFocus()
                                }
                            }
                        },
                        focusRequester = focusRequesters[i]
                    )
                }
            }
            Image(
                painter = painterResource(id = R.drawable.img_encode), contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(450.dp)
            )
            Spacer(modifier = Modifier.height(32.dp))
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFFFFA500)
                )
            ) {
                Text(
                    text = "Continue",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                )
            }
        }
    }
}

@Composable
fun CodeInputBox(value: String, onValueChange: (String) -> Unit, focusRequester: FocusRequester) {
    Box(
        modifier = Modifier
            .size(60.dp)
            .border(1.dp, Color.Gray),
        contentAlignment = Alignment.Center
    ) {
        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxSize()
                .focusRequester(focusRequester),
            singleLine = true,
            textStyle = TextStyle(
                textAlign = TextAlign.Center,
                fontSize = 16.sp
            ),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                textColor = Color.Black
            )
        )
    }
}


@Preview(showBackground = true)
@Composable
fun CodeInputScreenPreview() {
    val code = remember { mutableStateOf(List(5) { "" }) }
    val focusRequesters = List(5) { FocusRequester() }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        for (i in code.value.indices) {
            CodeInputBox(
                value = code.value[i],
                onValueChange = { newValue ->
                    if (newValue.length <= 1) {
                        code.value = code.value.toMutableList().apply { this[i] = newValue }
                        if (newValue.isNotEmpty() && i < code.value.size - 1) {
                            focusRequesters[i + 1].requestFocus()
                        }
                    }
                },
                focusRequester = focusRequesters[i]
            )
        }
    }
}