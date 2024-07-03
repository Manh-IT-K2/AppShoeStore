package com.example.appshoestore.Constant

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material.icons.Icons
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
import com.example.appshoestore.R

@Composable
fun ItemOrderDetail(
    idOder: String,
    dateOder: String,
    imageProduct: Int,
    nameProduct: String,
    priceProduct: String,
    statusOder: String,
    quantityProduct: String
) {
    Column(
        modifier = Modifier
            .background(Color.White)
            .padding(start = 16.dp, end = 16.dp, top = 22.dp)
    ) {
        Text(
            text = "Order Id: $idOder",
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        )
        Text(
            text = "Order Date: $dateOder",
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
                image = imageProduct,
                nameProduct = nameProduct,
                price = priceProduct,
                status = statusOder,
                quantity = quantityProduct,
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
                iconColor = Color.Blue.copy(alpha = 0.5f),
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
                        color = if (statusOder == "Shipped" || statusOder == "Delivered") Color.Blue.copy(
                            alpha = 0.5f
                        ) else Color.Gray.copy(
                            alpha = 0.5f
                        ),
                        textAlign = TextAlign.Center
                    )
                )
            }
            ItemSelectedStep(
                icon = Icons.Outlined.ShareLocation,
                background = if (statusOder == "Shipped" || statusOder == "Delivered") Color.Blue.copy(
                    alpha = 0.1f
                ) else Color.Gray.copy(
                    alpha = 0.2f
                ),
                iconColor = if (statusOder == "Shipped" || statusOder == "Delivered") Color.Blue.copy(
                    alpha = 0.5f
                ) else Color.Black,
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
                        color = if (statusOder == "Delivered") Color.Blue.copy(alpha = 0.5f) else Color.Gray.copy(
                            alpha = 0.5f
                        ),
                        textAlign = TextAlign.Center
                    )
                )
            }
            ItemSelectedStep(
                icon = Icons.Outlined.LocalShipping,
                background = if (statusOder == "Delivered") Color.Blue.copy(alpha = 0.1f) else Color.Gray.copy(
                    alpha = 0.2f
                ),
                iconColor = if (statusOder == "Delivered") Color.Blue.copy(alpha = 0.5f) else Color.Black,
                title = "Delivered"
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Button(
                onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFFF5F5F5),
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .height(50.dp)
                    .weight(1f)
            ) {
                Text(
                    text = "Return",
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
                    backgroundColor = Color(0xFFF5F5F5),
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .height(50.dp)
                    .weight(1f)
            ) {
                Text(
                    text = "Write a Review",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black
                    )
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
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
        Spacer(modifier = Modifier.height(22.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color.Gray.copy(alpha = 0.3f))
        )
    }
}

@Preview
@Composable
fun PreviewItemOrderDetail() {
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