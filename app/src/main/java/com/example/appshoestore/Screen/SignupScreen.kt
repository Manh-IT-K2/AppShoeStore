package com.example.appshoestore.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appshoestore.Constant.CustomOutlinedButton
import com.example.appshoestore.Constant.CustomOutlinedTextField
import com.example.appshoestore.Constant.CustomTextFieldPassword
import com.example.appshoestore.R

@Preview
@Composable
fun SignupScreen() {
    var scrollState = rememberScrollState()
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
            .padding(start = 22.dp, end = 22.dp)
            .verticalScroll(scrollState)

    ) {
        Column() {
            Spacer(modifier = Modifier.height(16.dp))
            Image(painter = painterResource(id = R.drawable.logo_app), contentDescription = null)
            Text(
                text = "Register Account \uD83D\uDC4B",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
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
                title = "User Name",
                value = "Qmanh",
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            CustomOutlinedTextField(
                title = "Email Address",
                value = "quanmanh@Gmail.com",
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            var txtPass by remember { mutableStateOf("") }

            CustomTextFieldPassword(
                title = "Password",
                value = txtPass,
                onTextChange = { txtPass = it },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            var txtRePass by remember { mutableStateOf("") }
            CustomTextFieldPassword(
                title = "Confirm Password",
                value = txtRePass,
                onTextChange = { txtRePass = it },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButtonSquare()
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = " I agree to the ",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color.Black
                        )
                    )
                    Text(
                        text = "Terms & Privacy Policy",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color.Blue.copy(alpha = 0.5f)
                        )
                    )
                }
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
                    text = "Register",
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
            Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                CustomOutlinedButton(
                    title = "Google",
                    icon = R.drawable.icon_google,
                    modifier = Modifier
                        .weight(1f)
                        .height(50.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                CustomOutlinedButton(
                    title = "Google",
                    icon = R.drawable.icon_facebook,
                    modifier = Modifier
                        .weight(1f)
                        .height(50.dp)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text(
                    text = "Already have an account?",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black
                    )
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = "Login",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Blue.copy(alpha = 0.5f)
                    )
                )
            }
            Spacer(modifier = Modifier.height(22.dp))
        }
    }

}

@Composable
fun RadioButtonSquare() {
    var isChecked by remember { mutableStateOf(false) }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(20.dp)
            .background(
                if (isChecked) Color(0xFFFFA500) else Color.Transparent,
                shape = RoundedCornerShape(6.dp)
            )
            .clickable { isChecked = !isChecked }
            .border(
                width = 2.dp,
                color = if (isChecked) Color(0xFFFFA500) else Color.Gray.copy(alpha = 0.5f)
            )
    ) {
        if (isChecked) {
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = "Checked",
                tint = Color.White,
                modifier = Modifier.size(30.dp)
            )
        }
    }
}