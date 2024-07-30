package com.example.appshoestore.Constant

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.outlined.DeleteOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appshoestore.R

@Composable
fun ItemCart(
    img: Int,
    nameProduct: String,
    price: String,
    quantity: String,
    onClickSubtract: () -> Unit = {},
    onClickSummation: () -> Unit = {},
    onClickRemove: () -> Unit = {}
) {
    Card(
        modifier = Modifier
            .height(100.dp)
            .fillMaxWidth()
            .padding(top = 10.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = 8.dp,
        backgroundColor = Color.White,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 16.dp)
        ) {
            Box(
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
                    .background(
                        Color.Gray.copy(alpha = 0.3f), shape = RoundedCornerShape(5.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = img),
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)
                        .rotate(20f)
                        .offset(x = 0.dp, y = (-2).dp)
                )
            }
            Column(modifier = Modifier.padding(start = 16.dp)) {
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
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Gray
                    )

                )
                Row(modifier = Modifier.padding(top = 6.dp)) {
                    Box(
                        modifier = Modifier
                            .width(20.dp)
                            .height(20.dp)
                            .clickable { onClickSubtract() }
                            .border(
                                border = BorderStroke(
                                    width = 1.dp,
                                    brush = SolidColor(Color.Gray.copy(alpha = 0.3f))
                                ),
                                shape = RoundedCornerShape(
                                    topStart = 3.dp,
                                    topEnd = 0.dp,
                                    bottomEnd = 0.dp,
                                    bottomStart = 3.dp
                                )
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Remove,
                            contentDescription = null,
                            tint = Color.Black,
                            modifier = Modifier.size(15.dp)
                        )
                    }
                    Column(
                        modifier = Modifier.size(20.dp),

                        ) {
                        // Top border
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(1.dp)
                                .background(Color.Gray.copy(alpha = 0.3f))
                        )
                        // Content
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = quantity,
                                color = Color.Black,
                                fontSize = 10.sp,
                                textAlign = TextAlign.Center
                            )
                        }
                        // Bottom border
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(1.dp)
                                .background(Color.Gray.copy(alpha = 0.3f))
                        )
                    }
                    Box(
                        modifier = Modifier
                            .width(20.dp)
                            .height(20.dp)
                            .clickable { onClickSummation() }
                            .border(
                                border = BorderStroke(
                                    width = 1.dp,
                                    brush = SolidColor(Color.Gray.copy(alpha = 0.3f))
                                ),
                                shape = RoundedCornerShape(
                                    topStart = 0.dp,
                                    topEnd = 3.dp,
                                    bottomEnd = 3.dp,
                                    bottomStart = 0.dp
                                )
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = null,
                            tint = Color.Black,
                            modifier = Modifier.size(15.dp)
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Box(modifier = Modifier.fillMaxHeight(), contentAlignment = Alignment.BottomEnd) {
                IconButton(onClick = { onClickRemove() }) {
                    Icon(
                        imageVector = Icons.Outlined.DeleteOutline,
                        contentDescription = null,
                        tint = Color.Red,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun TestItemCart() {
    ItemCart(img = R.drawable.s1, nameProduct = "Macbook", price = "$3200", quantity = "5")
}