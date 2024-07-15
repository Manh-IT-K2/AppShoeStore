package com.example.appshoestore.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Gamepad
import androidx.compose.material.icons.filled.GolfCourse
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appshoestore.Constant.CustomOutlinedTextField
import com.example.appshoestore.Constant.CustomTextFieldPassword
import com.example.appshoestore.R

@Preview
@Composable
fun LoginScreen() {
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
            .padding(start = 22.dp, end = 22.dp)

    ) {
        Column() {
            Spacer(modifier = Modifier.height(16.dp))
            Image(painter = painterResource(id = R.drawable.logo_app), contentDescription = null)
            Text(
                text = "Welcome Back \uD83D\uDC4B",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black
                )
            )
            Row() {
                Text(
                    text = "to",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black
                    )
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = "SHOESTORE",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Blue.copy(alpha = 0.5f)
                    )
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Hello there, login to continue",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Gray
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            CustomOutlinedTextField(
                title = "Email Address",
                value = "quanmanh@Gmail.com",
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            CustomTextFieldPassword(
                title = "Password",
                onTextChange = {},
                value = "Password",
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterEnd) {
                Text(
                    text = "Forgot Password?",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Blue.copy(alpha = 0.5f)
                    )
                )
            }
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
                    text = "Login",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .width(50.dp)
                        .height(1.dp)
                        .background(Color.Gray.copy(alpha = 0.1f))
                )
                Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                    Text(
                        text = "Or continue with social account", style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color.Gray
                        )
                    )
                }
                Box(
                    modifier = Modifier
                        .width(50.dp)
                        .height(1.dp)
                        .background(Color.Gray.copy(alpha = 0.1f))
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = "GooGle",
                onValueChange = { },
                label = { Text("") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Gamepad, // Đảm bảo bạn đã thêm icon Google vào drawable
                        contentDescription = "Google Icon",
                        tint = Color.Unspecified
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text(
                        text = "Google",
                        color = Color.Blue.copy(alpha = 0.3f)
                    )
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = Color.Blue,
                    focusedBorderColor = Color.Blue.copy(alpha = 0.3f),
                    unfocusedBorderColor = Color.Blue.copy(alpha = 0.3f),
                    backgroundColor = Color.Transparent
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text(
                    text = "Didn't have an account?",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black
                    )
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = "Register",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Blue.copy(alpha = 0.5f)
                    )
                )
            }
        }
    }
}