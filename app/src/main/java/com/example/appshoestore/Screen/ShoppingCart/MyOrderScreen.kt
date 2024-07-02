package com.example.appshoestore.Screen.ShoppingCart

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appshoestore.Constant.ItemOrder
import com.example.appshoestore.R

@Preview
@Composable
fun MyOrderScreen() {
    val scrollPage = rememberScrollState()
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
            .padding(start = 22.dp, end = 22.dp)
            .verticalScroll(scrollPage)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(modifier = Modifier.weight(1f)) {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBackIos,
                            contentDescription = null,
                            tint = Color.Black
                        )
                    }
                }
                Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                    Text(
                        text = "My Orders",
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    )
                }
                Box(modifier = Modifier.weight(1f))
            }
            Spacer(modifier = Modifier.height(16.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp),
                shape = RoundedCornerShape(12.dp),
                backgroundColor = Color.White,
                elevation = 8.dp
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp, 16.dp)
                ) {
                    Text(
                        text = "Order Id: 58967895",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    )
                    Text(
                        text = "Order Date: June 30, 2024",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color.Gray
                        ),
                        modifier = Modifier.padding(top = 6.dp)
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    val scrollState = rememberScrollState()
                    Column(
                        Modifier
                            .height(200.dp)
                            .verticalScroll(scrollState)) {
                        ItemOrder(
                            image = R.drawable.s6,
                            nameProduct = "Ios Samsung",
                            price = "$3200",
                            status = "Delivered",
                            quantity = "3",
                            colorTextStatus = Color.Blue,
                            colorBgStatus = Color.Blue.copy(alpha = 0.3f)
                        )
                        ItemOrder(
                            image = R.drawable.s8,
                            nameProduct = "Ios Macbook",
                            price = "$3200",
                            status = "Delivered",
                            quantity = "1",
                            colorTextStatus = Color.Blue,
                            colorBgStatus = Color.Blue.copy(alpha = 0.3f)
                        )
                        ItemOrder(
                            image = R.drawable.s6,
                            nameProduct = "Ios Samsung",
                            price = "$3200",
                            status = "Delivered",
                            quantity = "3",
                            colorTextStatus = Color.Blue,
                            colorBgStatus = Color.Blue.copy(alpha = 0.3f)
                        )
                        ItemOrder(
                            image = R.drawable.s8,
                            nameProduct = "Ios Macbook",
                            price = "$3200",
                            status = "Delivered",
                            quantity = "1",
                            colorTextStatus = Color.Blue,
                            colorBgStatus = Color.Blue.copy(alpha = 0.3f)
                        )
                    }

                    Spacer(modifier = Modifier.height(6.dp))
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Button(
                            onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color(0xFFF5F5F5),
                            ),
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier
                                .weight(1f)
                                .height(50.dp)
                        ) {
                            Text(
                                text = "View Details",
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Normal,
                                    color = Color.Black
                                )
                            )
                        }
                        Spacer(modifier = Modifier.width(16.dp))
                        Button(
                            onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color(0xFFFFA500),
                            ),
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier
                                .weight(1f)
                                .height(50.dp)
                        ) {
                            Text(
                                text = "Reorder",
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Normal,
                                    color = Color.White
                                )
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(22.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp),
                shape = RoundedCornerShape(12.dp),
                backgroundColor = Color.White,
                elevation = 8.dp
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp, 16.dp)
                ) {
                    Text(
                        text = "Order Id: 58967895",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    )
                    Text(
                        text = "Order Date: June 30, 2024",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color.Gray
                        ),
                        modifier = Modifier.padding(top = 6.dp)
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    val scrollState = rememberScrollState()
                    Column(
                        Modifier
                            .height(200.dp)
                            .verticalScroll(scrollState)) {
                        ItemOrder(
                            image = R.drawable.s6,
                            nameProduct = "Ios Samsung",
                            price = "$3200",
                            status = "Cancelled",
                            quantity = "7",
                            colorTextStatus = Color.Red,
                            colorBgStatus = Color.Red.copy(alpha = 0.3f)
                        )
                        ItemOrder(
                            image = R.drawable.s8,
                            nameProduct = "Ios Macbook",
                            price = "$3200",
                            status = "Cancelled",
                            quantity = "1",
                            colorTextStatus = Color.Red,
                            colorBgStatus = Color.Red.copy(alpha = 0.3f)
                        )
                    }

                    Spacer(modifier = Modifier.height(6.dp))
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Button(
                            onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color(0xFFF5F5F5),
                            ),
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier
                                .weight(1f)
                                .height(50.dp)
                        ) {
                            Text(
                                text = "View Details",
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Normal,
                                    color = Color.Black
                                )
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(22.dp))
        }
    }
}