package com.example.appshoestore.Screen.ShoppingCart

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.appshoestore.Constant.ItemCart
import com.example.appshoestore.Constant.ItemTextOrderSummary
import com.example.appshoestore.Navigation.NavigationItem
import com.example.appshoestore.R
import com.example.appshoestore.ui.theme.f1

@Composable
fun ShoppingCartScreen(navController: NavController) {
    val scrollState = rememberScrollState()
    Box(
        modifier = Modifier
            .background(Color.White)
            .padding(start = 22.dp, end = 22.dp)
            .fillMaxSize(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .background(Color.White)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Text(
                    text = "My Cart",
                    style = TextStyle(
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                    )
                )
            }
            Spacer(modifier = Modifier.height(22.dp))
            ItemCart(img = R.drawable.s7, nameProduct = "Samsung", price = "$3400", quantity = "2")
            ItemCart(img = R.drawable.s8, nameProduct = "Android", price = "$2500", quantity = "1")
            ItemCart(img = R.drawable.s6, nameProduct = "IOS", price = "$5000", quantity = "5")
            ItemTextOrderSummary(
                title = "Item Total",
                price = "$7000",
                color = Color.Black,
                fontWeight1 = FontWeight.Normal,
                fontWeight2 = FontWeight.Normal,
                fontSize = 16.sp
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 16.dp)
                    .height(70.dp)
                    .border(
                        border = BorderStroke(
                            width = 1.dp, brush = SolidColor(
                                Color.Blue.copy(alpha = 0.3f)
                            )
                        ),
                        shape = RoundedCornerShape(3.dp)
                    )
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(modifier = Modifier.padding(start = 16.dp)) {
                        Text(
                            text = "Enter Coupon",
                            style = TextStyle(
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Light,
                                color = Color.Blue.copy(alpha = 0.5f)
                            )
                        )
                        TextField(
                            value = "",
                            onValueChange = {},
                            placeholder = {
                                Text(
                                    text = "...",
                                    color = Color.Black,
                                    textAlign = TextAlign.Center
                                )
                            },
                            singleLine = true,
                            colors = TextFieldDefaults.textFieldColors(
                                backgroundColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                disabledIndicatorColor = Color.Transparent
                            ),
                            modifier = Modifier
                                .height(50.dp)
                                .width(100.dp)
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Button(
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFFFA500)),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.padding(end = 16.dp)
                    ) {
                        Text(
                            text = "Apply Coupon",
                            style = TextStyle(
                                fontWeight = FontWeight.Normal,
                                fontSize = 16.sp,
                                color = Color.White
                            )
                        )
                    }
                }
            }
            ItemTextOrderSummary(
                title = "Discount",
                price = "$70",
                color = Color.Black,
                fontWeight1 = FontWeight.Normal,
                fontWeight2 = FontWeight.Normal,
                fontSize = 16.sp
            )
            ItemTextOrderSummary(
                title = "Delivery Free",
                price = "$0",
                color = Color(0xFF08C26F),
                fontWeight1 = FontWeight.Normal,
                fontWeight2 = FontWeight.Normal,
                fontSize = 16.sp
            )
            Box(
                modifier = Modifier
                    .padding(0.dp, 22.dp)
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(Color.Gray.copy(alpha = 0.3f))

            )
            ItemTextOrderSummary(
                title = "Grand Total",
                price = "$7100",
                color = Color.Black,
                fontWeight1 = FontWeight.Bold,
                fontWeight2 = FontWeight.Bold,
                fontSize = 22.sp
            )
            Button(
                onClick = {
                          navController.navigate(NavigationItem.SHIPPING)
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFFFA500)),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .padding(0.dp, 22.dp)
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(
                    text = "Buy",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp,
                        color = Color.White
                    )
                )
            }
            Spacer(modifier = Modifier.height(80.dp))
        }
    }
}