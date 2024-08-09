package com.example.appshoestore.Screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.appshoestore.Constant.CustomOutlinedButton
import com.example.appshoestore.Constant.CustomOutlinedTextField
import com.example.appshoestore.Constant.CustomTextFieldPassword
import com.example.appshoestore.Model.User
import com.example.appshoestore.Navigation.NavigationItem
import com.example.appshoestore.R
import com.example.appshoestore.Request.LoginAccountRequest
import com.example.appshoestore.Util.ApiResponse
import com.example.appshoestore.ViewModel.UserViewModel

@Composable
fun LoginScreen(navController: NavController) {
    val context = LocalContext.current

    //
    var email by remember {
        mutableStateOf("")
    }
    var passWord by remember {
        mutableStateOf("")
    }

    // get the viewModel
    val viewModel: UserViewModel = viewModel()

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
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            )
            Row() {
                Text(
                    text = "to",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
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
                value = email,
                onTextChange = {email = it},
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            CustomTextFieldPassword(
                title = "Password",
                value = passWord,
                onTextChange = {passWord = it},
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
                    ),
                    modifier = Modifier.clickable {
                        navController.navigate(NavigationItem.FORGOT_PASSWORD)
                    }
                )
            }
            Spacer(modifier = Modifier.height(32.dp))
            Button(
                onClick = {
                  if (email != "" || passWord != ""){
                      val request = LoginAccountRequest(email, passWord);
                      viewModel.loginAccount(request)
                  } else {
                      Toast.makeText(context, "Please complete all information", Toast.LENGTH_SHORT).show()
                  }
                },
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
            viewModel.loginAccountResponse.observe(LocalLifecycleOwner.current) { response ->
                if (response != null){
                    if (response.status) {
                        Toast.makeText(context, "Login successfully", Toast.LENGTH_SHORT).show()
                        navController.navigate(NavigationItem.HOME)
                    } else {
                        Toast.makeText(context, "Failed to login", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(context, "Failed to login", Toast.LENGTH_SHORT).show()
                }
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
                    ),
                    modifier = Modifier.clickable {
                        navController.navigate(NavigationItem.SIGNUP)
                    }
                )
            }
        }
    }
}