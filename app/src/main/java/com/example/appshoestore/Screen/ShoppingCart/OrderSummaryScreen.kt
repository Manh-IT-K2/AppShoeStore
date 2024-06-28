package com.example.appshoestore.Screen.ShoppingCart

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.EditNote
import androidx.compose.material.icons.outlined.CreditCard
import androidx.compose.material.icons.outlined.Description
import androidx.compose.material.icons.outlined.LocationOn
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

@Preview
@Composable
fun OrderSummaryScreen() {
    Box(
        modifier = Modifier
            .background(Color.White)
            .padding(22.dp, 16.dp)
            .fillMaxSize()
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
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
                        text = "Checkout",
                        style = TextStyle(
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    )
                }
                Box(modifier = Modifier.weight(1f))
            }
            Row(
                modifier = Modifier
                    .padding(top = 30.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                ItemSelectedStep(
                    icon = Icons.Outlined.LocationOn,
                    background = Color.Blue.copy(alpha = 0.2f),
                    iconColor = Color.Blue.copy(alpha = 0.3f),
                    title = "Address"
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
                            color = Color.Blue.copy(alpha = 0.5f),
                            textAlign = TextAlign.Center
                        )
                    )
                }
                ItemSelectedStep(
                    icon = Icons.Outlined.CreditCard,
                    background = Color.Blue.copy(alpha = 0.2f),
                    iconColor = Color.Blue.copy(alpha = 0.3f),
                    title = "Payment"
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
                            color = Color.Blue.copy(alpha = 0.5f),
                            textAlign = TextAlign.Center
                        )
                    )
                }
                ItemSelectedStep(
                    icon = Icons.Outlined.Description,
                    background = Color.Blue.copy(alpha = 0.2f),
                    iconColor = Color.Blue.copy(alpha = 0.3f),
                    title = "Summery"
                )
            }
            Text(
                text = "Item Details",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                ),
                modifier = Modifier.padding(top = 16.dp)
            )
            val scrollState = rememberScrollState()
            Card(
                modifier = Modifier
                    .padding(top = 22.dp)
                    .height(300.dp)
                    .fillMaxWidth(),
                elevation = 8.dp,
                shape = RoundedCornerShape(12.dp),
                backgroundColor = Color.White
            ) {
                Column {
                    ItemPurchasedProduct(
                        imageProduct = R.drawable.s4,
                        nameProduct = "Mobius OS",
                        price = "$1200",
                        quantity = 2
                    )
                    ItemPurchasedProduct(
                        imageProduct = R.drawable.s5,
                        nameProduct = "Airs OS",
                        price = "$2200",
                        quantity = 3
                    )
                    ItemPurchasedProduct(
                        imageProduct = R.drawable.s7,
                        nameProduct = "Jordan OS",
                        price = "$3200",
                        quantity = 1
                    )

                }
            }
            Text(
                text = "Delivery Address",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                ),
                modifier = Modifier.padding(top = 22.dp)
            )
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(top = 16.dp),
                elevation = 8.dp,
                shape = RoundedCornerShape(12.dp),
                backgroundColor = Color.White
            ) {
                Row() {
                    Column(
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .width(270.dp)
                            .fillMaxHeight(),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Manh-IT-K2",
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black
                            )
                        )
                        Text(
                            text = "309/1/4 Le Duc Tho, P17, Go Vap",
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color.Black
                            )
                        )
                    }
                    Box(
                        modifier = Modifier
                            .width(40.dp)
                            .height(40.dp)
                            .padding(top = 10.dp, start = 6.dp)
                            .background(
                                Color.Blue.copy(alpha = 0.1f),
                                shape = RoundedCornerShape(5.dp)
                            )
                    ) {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Default.EditNote,
                                contentDescription = null,
                                tint = Color.Blue.copy(alpha = 0.5f)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ItemPurchasedProduct(
    imageProduct: Int,
    nameProduct: String,
    price: String,
    quantity: Int
) {
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
            .height(90.dp)
            .padding(start = 16.dp, top = 16.dp)

    ) {
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .width(100.dp)
                    .height(70.dp)
                    .background(
                        Color.Gray.copy(alpha = 0.1f), shape = RoundedCornerShape(12.dp),
                    ),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = imageProduct),
                    contentDescription = null,
                    modifier = Modifier
                        .size(70.dp)
                        .rotate(20f)
                        .offset(x = 0.dp, y = (-4).dp)
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
                        color = Color.Black
                    ),
                    modifier = Modifier.padding(top = 6.dp)
                )
                Text(
                    text = "QTY: $quantity",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black
                    ),
                    modifier = Modifier.padding(top = 6.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewItemPurchasedProduct() {
    ItemPurchasedProduct(
        imageProduct = R.drawable.s1,
        nameProduct = "Mobius OG",
        price = "$1200",
        quantity = 2
    )
}