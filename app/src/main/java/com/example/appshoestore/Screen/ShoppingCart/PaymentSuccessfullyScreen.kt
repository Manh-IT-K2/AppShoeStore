package com.example.appshoestore.Screen.ShoppingCart

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
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
import com.example.appshoestore.R

@Preview
@Composable
fun PaymentSuccessfullyScreen() {
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
            .padding(start = 22.dp, end = 22.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Your payment done successfully", style = TextStyle(
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            )
            Image(
                painter = painterResource(id = R.drawable.payment_success),
                contentDescription = null,
                modifier = Modifier.size(350.dp)
            )
            Text(
                text = "Thank you shopping with us",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black
                )
            )
            Text(
                text = "See Order Details",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Blue.copy(alpha = 0.5f)
                ),
                modifier = Modifier.padding(top = 16.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Button(
                onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFFFFA500),
                ), shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
            ) {
                Text(
                    text = "Back to Home",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                )
            }
            Spacer(modifier = Modifier.height(50.dp))
        }
    }
}