package com.example.appshoestore.Screen


import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.asComposeRenderEffect
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.PratikFagadiya.smoothanimationbottombar.model.SmoothAnimationBottomBarScreens
import com.PratikFagadiya.smoothanimationbottombar.properties.BottomBarProperties
import com.PratikFagadiya.smoothanimationbottombar.ui.SmoothAnimationBottomBar
import com.PratikFagadiya.smoothanimationbottombar.ui.theme.BlueTint
import com.example.appshoestore.Component.ProductItem
import com.example.appshoestore.MainActivity
import com.example.appshoestore.Model.OnBoarding
import com.example.appshoestore.Model.OnBoardingAd
import com.example.appshoestore.Model.Products
import com.example.appshoestore.Navigation.AppNavigationHost
import com.example.appshoestore.Navigation.NavigationItem
import com.example.appshoestore.R

import com.example.appshoestore.ui.theme.f1

import kotlinx.coroutines.delay
import kotlinx.coroutines.yield


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(navController: NavController) {
    var products = remember {
        getProductList()
    }
    val page = listOf(OnBoardingAd.AdOne, OnBoardingAd.AdTwo, OnBoardingAd.AdThree)
    val pagerState = rememberPagerState(initialPage = 0) {
        page.size
    }

    // Auto-scroll logic
    LaunchedEffect(pagerState) {
        while (true) {
            yield()
            delay(3000) // Delay for 3 seconds
            val currentPage = pagerState.currentPage
            val nextPage = if (currentPage < page.size - 1) currentPage + 1 else 0
            pagerState.animateScrollToPage(nextPage)
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 6.dp, bottom = 6.dp)
    ) {
        Column {
            headerScreen(
                onclick = {
                    navController.navigate(NavigationItem.NOTIFICATION)
                }
            )
            //LazyColumn {
            //item {
            Spacer(modifier = Modifier.height(16.dp))
            Card(
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth()
                    .padding(start = 22.dp, end = 22.dp)
                    .clickable {
                        navController.navigate(NavigationItem.SEARCH)
                    },
                shape = RoundedCornerShape(12.dp),
                backgroundColor = Color.White,
                elevation = 8.dp
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(start = 16.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null,
                        tint = Color.Black
                    )
                    TextField(
                        value = "", onValueChange = {
                        },
                        placeholder = {
                            Text(
                                text = "Search",
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Normal,
                                    color = Color.Gray.copy(alpha = 0.6f)
                                )
                            )
                        },
                        singleLine = true,
                        enabled = false,
                        modifier = Modifier.weight(1f),
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent
                        )
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Scaffold(modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(start = 22.dp, end = 22.dp, top = 10.dp)
                .clip(RoundedCornerShape(10.dp)),
                content = {
                    Column(Modifier.padding(it)) {
                        HorizontalPager(state = pagerState) { index ->
                            OnBoardingAdUI(onBoarding = page[index])
                        }
                    }
                },
                bottomBar = {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(30.dp)
                            .fillMaxWidth()
                            .background(Color.White),
                        contentAlignment = Alignment.Center,

                        ) {
                        IndicatorUI(
                            pageSize = page.size,
                            currentPage = pagerState.currentPage
                        )
                    }
                }
            )
            //}
            Text(
                text = "Recommend",
                modifier = Modifier.padding(start = 22.dp, bottom = 6.dp),
                color = Color.Black,
                fontSize = 22.sp,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontFamily = f1,
                    platformStyle = PlatformTextStyle(includeFontPadding = false)
                )
            )

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .padding(8.dp)

            ) {
                items(products) {
                    ProductItem(product = it) {
                        navController.navigate("${NavigationItem.PRODUCT_DETAIL}/${it.id}")
                    }
                }
            }

        }
    }
}

@Preview
@Composable
fun PreviewHomeScreen() {
    var navController = rememberNavController();
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        HomeScreen(navController = navController)
    }
}

@Composable
fun OnBoardingAdUI(onBoarding: OnBoardingAd) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(20.dp)
            .background(Color.White)
            .clip(RoundedCornerShape(10.dp))
    ) {
        Image(
            painter = painterResource(id = onBoarding.image),
            contentDescription = null,
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp)),
            contentScale = ContentScale.Crop,
            alignment = Alignment.Center
        )
    }
}

@Composable
fun headerScreen(onclick: () -> Unit = {}) {
    Box(
        modifier = Modifier
            .padding(top = 16.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 22.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Hi!, QManh",
                    color = Color.Black,
                    fontSize = 12.sp,
                    style = TextStyle(
                        fontFamily = f1,
                        fontWeight = FontWeight.Normal,
                        platformStyle = PlatformTextStyle(includeFontPadding = false)
                    )
                )
                Text(
                    text = "Let's order your \nfavorite shoes",
                    color = Color.Black,
                    fontSize = 22.sp,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(includeFontPadding = false),
                        fontWeight = FontWeight.Light,
                        fontFamily = f1
                    ),
                    modifier = Modifier.padding(top = 5.dp)
                )
            }

            Box{
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = null,
                    tint = Color.Black,
                    modifier = Modifier.size(35.dp).
                            clickable { onclick() }
                )
            }
        }
    }

}

//@Composable
//@Preview(device = "id:pixel_4a", showBackground = true, backgroundColor = 0xFFFFFFFF)
//private fun MainScreenPreview() {
//    AppShoeStoreTheme {
//        MainActivity()
//    }
//}

fun getProductList(): List<Products> {
    return listOf(
        Products(
            id = "1",
            color = Color.Blue,
            price = 1200f,
            name = "Shoes Blue",
            discount = 1000f,
            rating = 4.7f,
            imageRes = R.drawable.s1,
            size = 8
        ),
        Products(
            id = "2",
            color = Color.Magenta,
            price = 1200f,
            name = "Shoes Pink",
            discount = 1000f,
            rating = 4.7f,
            imageRes = R.drawable.s2,
            size = 8
        ),
        Products(
            id = "3",
            color = Color(0xFF8B784D),
            price = 1200f,
            name = "Shoes Dark Yellow",
            discount = 1000f,
            rating = 4.7f,
            imageRes = R.drawable.s3,
            size = 8
        ),
        Products(
            id = "4",
            color = Color.Red,
            price = 1200f,
            name = "Shoes Red",
            discount = 1000f,
            rating = 4.7f,
            imageRes = R.drawable.s4,
            size = 8
        ),
        Products(
            id = "5",
            color = Color(0xFFA66842),
            price = 1200f,
            name = "Shoes Brown",
            discount = 1000f,
            rating = 4.7f,
            imageRes = R.drawable.s5,
            size = 8
        ),
        Products(
            id = "6",
            color = Color.Gray,
            price = 1200f,
            name = "Shoes Gray",
            discount = 1000f,
            rating = 4.7f,
            imageRes = R.drawable.s6,
            size = 8
        ),
        Products(
            id = "7",
            color = Color(0xFFBE8726),
            price = 1200f,
            name = "Shoes Yellow",
            discount = 1000f,
            rating = 4.7f,
            imageRes = R.drawable.s7,
            size = 8
        ),
        Products(
            id = "8",
            color = Color.Green,
            price = 1200f,
            name = "Shoes Green",
            discount = 1000f,
            rating = 4.7f,
            imageRes = R.drawable.s8,
            size = 8
        )
    )
}
