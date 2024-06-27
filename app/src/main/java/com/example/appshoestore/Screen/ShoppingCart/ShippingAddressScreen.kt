package com.example.appshoestore.Screen.ShoppingCart

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonColors
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.CreditCard
import androidx.compose.material.icons.outlined.Description
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun ShippingAddressScreen() {
    Box(
        modifier = Modifier
            .background(Color.White)
            .padding(22.dp, 22.dp)
            .fillMaxSize()
    ) {
        Column() {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .weight(0.5f)

                ) {
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
                        text = "Select Address",
                        style = TextStyle(
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            textAlign = TextAlign.Center
                        )
                    )
                }
                Box(modifier = Modifier.weight(0.5f))
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
                            color = Color.Gray.copy(alpha = 0.3f),
                            textAlign = TextAlign.Center
                        )
                    )
                }
                ItemSelectedStep(
                    icon = Icons.Outlined.CreditCard,
                    background = Color.Gray.copy(alpha = 0.2f),
                    iconColor = Color.Black,
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
                            color = Color.Gray.copy(alpha = 0.3f),
                            textAlign = TextAlign.Center
                        )
                    )
                }
                ItemSelectedStep(
                    icon = Icons.Outlined.Description,
                    background = Color.Gray.copy(alpha = 0.2f),
                    iconColor = Color.Black,
                    title = "Summery"
                )
            }
            var selectedAddress = false
            Spacer(modifier = Modifier.height(22.dp))
            ItemAddress(
                title = "Home",
                detail = "309/1/4 Lê Đức Thọ.\nP17, Go Vap, HCM",
                select = selectedAddress,
                onClickChose = {
                    selectedAddress = !selectedAddress

                })
            ItemAddress(
                title = "Work",
                detail = "309/1/4 Lê Đức Thọ.\nP17, Go Vap, HCM",
                select = selectedAddress,
                onClickChose = {
                    selectedAddress = !selectedAddress
                })
            ItemAddress(
                title = "Others",
                detail = "309/1/4 Lê Đức Thọ.\nP17, Go Vap, HCM",
                select = selectedAddress,
                onClickChose = {
                    selectedAddress = !selectedAddress
                })
            Spacer(modifier = Modifier.height(30.dp))
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFFFA500)),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = null,
                        tint = Color.White
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        text = "Add New Address",
                        style = TextStyle(
                            fontWeight = FontWeight.Normal,
                            fontSize = 22.sp,
                            color = Color.White
                        )
                    )
                }
            }
            Spacer(modifier = Modifier.height(100.dp))
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFFFA500)),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
            ) {
                Text(
                    text = "Next",
                    style = TextStyle(
                        fontWeight = FontWeight.Normal,
                        fontSize = 22.sp,
                        color = Color.White
                    )
                )
            }
        }
    }
}

@Composable
fun ItemSelectedStep(
    icon: ImageVector,
    background: Color,
    iconColor: Color,
    title: String
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .height(50.dp)
                .width(50.dp)
                .background(background, shape = RoundedCornerShape(5.dp)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = iconColor,
                modifier = Modifier.size(30.dp)
            )
        }
        Text(
            text = title,
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black
            ),
            modifier = Modifier.padding(top = 6.dp)
        )
    }
}

@Preview
@Composable
fun TestItemSelectedStep() {
    ItemSelectedStep(
        icon = Icons.Outlined.LocationOn,
        background = Color.Gray,
        iconColor = Color.Black,
        title = "Address"
    )
}

@Composable
fun ItemAddress(
    title: String,
    detail: String,
    select: Boolean,
    onClickChose: () -> Unit = {}
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(top = 10.dp)
            .clickable { onClickChose() },
        elevation = 8.dp,
        shape = RoundedCornerShape(12.dp)
    ) {

        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = select, onClick = { /*TODO*/ }, colors = RadioButtonDefaults.colors(
                    Color.Blue.copy(alpha = 0.3f)
                )
            )
            Column(modifier = Modifier.width(250.dp)) {
                Text(
                    text = title,
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                )
                Text(
                    text = detail,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black
                    )
                )
            }
            IconButton(onClick = { /*TODO*/ }, modifier = Modifier.weight(1f)) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = null,
                    tint = Color.Black
                )
            }
        }
    }
}

@Preview
@Composable
fun TestItemAddress() {
    ItemAddress(title = "Home", select = true, detail = "309/1/4 Lê Đức Thọ. \n P17,  Go Vap, HCM")
}