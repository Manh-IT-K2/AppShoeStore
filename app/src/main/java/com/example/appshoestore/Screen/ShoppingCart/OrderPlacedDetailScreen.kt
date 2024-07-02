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
import androidx.compose.material.icons.outlined.LocalShipping
import androidx.compose.material.icons.outlined.ShareLocation
import androidx.compose.material.icons.outlined.Token
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appshoestore.Constant.ItemOrder
import com.example.appshoestore.Constant.ItemSelectedStep
import com.example.appshoestore.Constant.ItemTextOrderSummary
import com.example.appshoestore.R

@Preview
@Composable
fun OrderPlacedDetailScreen() {
    Box(
        Modifier
            .background(Color.White)
            .fillMaxSize()
            .padding(start = 22.dp, end = 22.dp)
    ) {
        Column() {
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(modifier = Modifier.weight(0.5f)) {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBackIos,
                            contentDescription = null,
                            tint = Color.Black
                        )
                    }
                }
                Box(modifier = Modifier.weight(2f), contentAlignment = Alignment.Center) {
                    Text(
                        text = "Order Details",
                        style = TextStyle(
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    )
                }
                Box(modifier = Modifier.weight(0.5f))
            }
            Spacer(modifier = Modifier.height(32.dp))
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
                            .height(100.dp)
                            .verticalScroll(scrollState)
                    ) {
                        ItemOrder(
                            image = R.drawable.s6,
                            nameProduct = "Ios Samsung",
                            price = "$3200",
                            status = "Placed",
                            quantity = "7",
                            colorTextStatus = Color.Blue.copy(alpha = 0.5f),
                            colorBgStatus = Color.Blue.copy(alpha = 0.1f)
                        )
                    }
                    Row(
                        modifier = Modifier
                            .padding(top = 16.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        ItemSelectedStep(
                            icon = Icons.Outlined.Token,
                            background = Color.Blue.copy(alpha = 0.1f),
                            iconColor = Color.Blue.copy(alpha = 0.3f),
                            title = "Placed"
                        )
                        Box(
                            modifier = Modifier
                                .height(50.dp)
                                .width(70.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "- - - - - - - - -",
                                style = TextStyle(
                                    color = Color.Gray.copy(alpha = 0.3f),
                                    textAlign = TextAlign.Center
                                )
                            )
                        }
                        ItemSelectedStep(
                            icon = Icons.Outlined.ShareLocation,
                            background = Color.Gray.copy(alpha = 0.2f),
                            iconColor = Color.Black,
                            title = "Shipped"
                        )
                        Box(
                            modifier = Modifier
                                .height(50.dp)
                                .width(70.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "- - - - - - - - -",
                                style = TextStyle(
                                    color = Color.Gray.copy(alpha = 0.3f),
                                    textAlign = TextAlign.Center
                                )
                            )
                        }
                        ItemSelectedStep(
                            icon = Icons.Outlined.LocalShipping,
                            background = Color.Gray.copy(alpha = 0.2f),
                            iconColor = Color.Black,
                            title = "Delivered"
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
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
                                text = "Cancel Order",
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
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Delivery Address",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = "4517 Washington Ave. Manchester, Kentucky 39595",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = Modifier
                    .background(Color.Gray.copy(alpha = 0.3f))
                    .height(1.dp)
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Order Summary",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            )
            ItemTextOrderSummary(
                title = "Item Total",
                price = "$3150",
                color = Color.Black,
                fontWeight1 = FontWeight.Normal,
                fontWeight2 = FontWeight.Bold,
                fontSize = 16.sp
            )
            ItemTextOrderSummary(
                title = "Discount",
                price = "$20",
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
            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(Color.Gray.copy(alpha = 0.2f))
            )
            ItemTextOrderSummary(
                title = "Grand Total",
                price = "$3130",
                color = Color.Black,
                fontWeight1 = FontWeight.Bold,
                fontWeight2 = FontWeight.Bold,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(22.dp))
        }
    }
}