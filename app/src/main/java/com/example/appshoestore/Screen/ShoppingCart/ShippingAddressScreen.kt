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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.outlined.CreditCard
import androidx.compose.material.icons.outlined.Description
import androidx.compose.material.icons.outlined.LocationOn
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
import androidx.navigation.NavController
import com.example.appshoestore.Constant.ItemAddress
import com.example.appshoestore.Constant.ItemSelectedStep
import com.example.appshoestore.Navigation.NavigationItem

@Composable
fun ShippingAddressScreen(navController: NavController) {
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
                    .height(50.dp)
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
                            fontSize = 16.sp,
                            color = Color.White
                        )
                    )
                }
            }
            Spacer(modifier = Modifier.height(50.dp))
            Button(
                onClick = {
                    navController.navigate(NavigationItem.PAYMENT)
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFFFA500)),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(
                    text = "Next",
                    style = TextStyle(
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp,
                        color = Color.White
                    )
                )
            }
        }
    }
}