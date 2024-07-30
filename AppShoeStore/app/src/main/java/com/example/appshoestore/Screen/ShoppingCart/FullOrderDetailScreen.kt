package com.example.appshoestore.Screen.ShoppingCart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.appshoestore.Constant.ItemOrderDetail
import com.example.appshoestore.Constant.ItemTextOrderSummary
import com.example.appshoestore.Navigation.NavigationItem
import com.example.appshoestore.R

@Composable
fun FullOrderDetailScreen(navController: NavController) {
    var scrollState = rememberScrollState()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(start = 22.dp, end = 22.dp)
            .verticalScroll(scrollState)
    ) {
        Column() {
            Spacer(modifier = Modifier.height(16.dp))
            Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                Box(modifier = Modifier.weight(0.5f)) {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBackIos,
                            contentDescription = null,
                            tint = Color.Black
                        )
                    }
                }
                Box(modifier = Modifier.weight(2f), contentAlignment = Alignment.Center) {
                    Text(
                        text = "Order Detail",
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
                    .height(850.dp),
                shape = RoundedCornerShape(12.dp),
                backgroundColor = Color.White,
                elevation = 8.dp
            ) {
                var scroll = rememberScrollState()
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .verticalScroll(scroll)
                ) {
                    ItemOrderDetail(
                        idOder = "58967895",
                        dateOder = "June 03, 2024",
                        imageProduct = R.drawable.s2,
                        nameProduct = "Mobius OG",
                        priceProduct = "$4300",
                        statusOder = "Delivered",
                        quantityProduct = "4"
                    )
                    ItemOrderDetail(
                        idOder = "58967895",
                        dateOder = "June 03, 2024",
                        imageProduct = R.drawable.s2,
                        nameProduct = "Mobius OG",
                        priceProduct = "$4300",
                        statusOder = "Delivered",
                        quantityProduct = "4"
                    )
                    ItemOrderDetail(
                        idOder = "58967895",
                        dateOder = "June 03, 2024",
                        imageProduct = R.drawable.s2,
                        nameProduct = "Mobius OG",
                        priceProduct = "$4300",
                        statusOder = "Delivered",
                        quantityProduct = "4"
                    )
                    ItemOrderDetail(
                        idOder = "58967895",
                        dateOder = "June 03, 2024",
                        imageProduct = R.drawable.s2,
                        nameProduct = "Mobius OG",
                        priceProduct = "$4300",
                        statusOder = "Delivered",
                        quantityProduct = "4"
                    )
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
            Button(
                onClick = {
                    navController.navigate(NavigationItem.ORDER_PLACED_DETAIL)
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFFFFA500)
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Outlined.Visibility,
                        contentDescription = null,
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        text = "View Invoice",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            color = Color.White
                        )
                    )
                }
            }
            Spacer(modifier = Modifier.height(22.dp))
        }
    }
}