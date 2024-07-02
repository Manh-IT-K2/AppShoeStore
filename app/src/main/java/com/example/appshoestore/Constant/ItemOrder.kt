package com.example.appshoestore.Constant

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appshoestore.R

@Composable
fun ItemOrder(
    image: Int,
    nameProduct: String,
    price: String,
    status: String,
    quantity: String,
    colorTextStatus: Color,
    colorBgStatus: Color
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .height(100.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .width(70.dp)
                    .height(70.dp)
                    .background(
                        Color.Gray.copy(alpha = 0.3f), shape = RoundedCornerShape(5.dp),
                    ),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = null,
                    modifier = Modifier
                        .size(60.dp)
                        .rotate(20f)
                        .offset(x = 3.dp, y = 0.dp)
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column() {
                Text(
                    text = nameProduct,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                )
                Text(
                    text = price,
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black
                    ),
                    modifier = Modifier.padding(top = 6.dp)
                )
                Spacer(modifier = Modifier.height(6.dp))
                Box(
                    modifier = Modifier
                        .background(
                            color = colorBgStatus,
                            shape = RoundedCornerShape(5.dp)
                        )
                        .width(75.dp)
                        .height(20.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = status,
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal,
                            color = colorTextStatus,
                            textAlign = TextAlign.Center
                        )
                    )
                }
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(), contentAlignment = Alignment.CenterEnd
            ) {
                Text(
                    text = "Qty: $quantity",
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

@Preview
@Composable
fun PreviewItemOrder() {
    ItemOrder(
        image = R.drawable.s2,
        nameProduct = "ManhK2",
        price = "$1000",
        status = "Delivered",
        quantity = "3",
        colorTextStatus = Color.Black,
        colorBgStatus = Color.Red
    )
}