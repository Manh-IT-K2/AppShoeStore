package com.example.appshoestore.Screen

import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.DeleteOutline
import androidx.compose.material.icons.outlined.Remove
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appshoestore.R
import com.example.appshoestore.ui.theme.f1

@Preview
@Composable
fun PreviewFavoriteScreen(){
    FavoriteScreen(navController = rememberNavController())
}
@Composable
fun FavoriteScreen(navController: NavController) {
    val scrollState = rememberScrollState()
    Box(
        modifier = Modifier
            .background(Color.White)
            .padding(start = 22.dp, end = 22.dp)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .background(Color.White)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(Modifier.weight(0.5f)) {
                    IconButton(
                        onClick = { navController.popBackStack() },
                        modifier = Modifier
                            .padding(top = 16.dp)
                            .shadow(
                                elevation = 24.dp,
                                spotColor = DefaultShadowColor,
                                shape = RoundedCornerShape(12.dp)
                            )
                            .background(color = Color.White, shape = RoundedCornerShape(22.dp))
                            .size(36.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.KeyboardArrowLeft,
                            contentDescription = null,
                            tint = Color.Black
                        )
                    }
                }
                Box(modifier = Modifier.weight(2f), contentAlignment = Alignment.Center) {
                    Text(
                        text = "My Favorites",
                        style = TextStyle(
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                            fontFamily = f1
                        )
                    )
                }
                Box(modifier = Modifier.weight(0.5f))
            }
            Spacer(modifier = Modifier.height(16.dp))
            ItemMyFavorite(img = R.drawable.s1, nameProduct = "Macbook", price = "$3900")
            ItemMyFavorite(img = R.drawable.s2, nameProduct = "Samsung", price = "$7100")
            ItemMyFavorite(img = R.drawable.s3, nameProduct = "Galaxy", price = "$5900")
            ItemMyFavorite(img = R.drawable.s4, nameProduct = "Readme", price = "$2300")
            ItemMyFavorite(img = R.drawable.s5, nameProduct = "Ios", price = "$2600")
            ItemMyFavorite(img = R.drawable.s6, nameProduct = "Android", price = "$1700")
            Spacer(modifier = Modifier.height(32.dp))

        }
    }
}

@Composable
fun ItemMyFavorite(
    img: Int,
    nameProduct: String,
    price: String,
    onClickRemove: () -> Unit = {},
    onClickBuy: () -> Unit = {}
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
            .height(100.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = 8.dp,
        backgroundColor = Color.White
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Card(
                modifier = Modifier
                    .height(50.dp)
                    .width(50.dp)
                    .background(
                        color = Color.Gray.copy(alpha = 0.3f),
                        shape = RoundedCornerShape(10.dp)
                    ),
                elevation = 8.dp,

                ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
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
            }
            Column(modifier = Modifier.padding(start = 10.dp)) {
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
                        color = Color.Gray
                    )
                )
                Box(
                    modifier = Modifier
                        .height(30.dp)
                        .width(90.dp)
                        .padding(top = 6.dp)
                        .background(
                            color = Color.Blue.copy(alpha = 0.3f),
                            shape = RoundedCornerShape(5.dp)
                        )
                        .clickable { onClickBuy.invoke() },
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.ShoppingCart,
                            contentDescription = null,
                            modifier = Modifier.size(16.dp),
                            tint = Color.White
                        )
                        Text(
                            text = "Move to bag",
                            style = TextStyle(
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Normal,
                                color = Color.White
                            )
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = { onClickRemove() }) {
                Icon(
                    imageVector = Icons.Outlined.DeleteOutline,
                    contentDescription = null,
                    tint = Color.Red
                )
            }
        }
    }
}

@Preview
@Composable
fun TestItemMyFavorite() {
    ItemMyFavorite(img = R.drawable.s1, nameProduct = "Adidas", price = "$2700")
}