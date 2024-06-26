package com.example.appshoestore.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appshoestore.R

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SearchScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(top = 16.dp),
        //contentAlignment = Alignment.Center
    ) {
        Column() {
            Card(
                modifier = Modifier
                    .height(70.dp)
                    .fillMaxWidth()
                    .padding(start = 22.dp, end = 22.dp, top = 10.dp)
                    .clickable { },
                shape = RoundedCornerShape(15.dp),
                elevation = 8.dp,
                backgroundColor = Color.White
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(start = 16.dp)
                ) {
                    // Icon search
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Search",
                        tint = Color.Black
                    )
                    // Spacing between icon and text
                    Spacer(modifier = Modifier.width(1.dp))
                    // Text field for search input
                    TextField(
                        value = "",
                        onValueChange = { /* TODO: Handle value change */ },
                        placeholder = {
                            Text(
                                text = "Search",
                                color = Color.Gray.copy(alpha = 0.6f)
                            )
                        },
                        singleLine = true, // Đảm bảo chỉ có một dòng
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
            Row(
                Modifier
                    .padding(horizontal = 22.dp)
                    .padding(top = 22.dp, bottom = 16.dp)
            ) {
                Text(
                    text = "Recently Search", style = TextStyle(
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Clear", style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Blue.copy(alpha = 0.5f)
                    )
                )
            }

            val items = remember { List(3) { "Item $it" } }
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
                    .padding(horizontal = 22.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(items) { item ->
                    ItemRecentSearch(title = item)
                }
            }
            Row(
                Modifier
                    .padding(horizontal = 22.dp)
                    .padding(top = 22.dp, bottom = 16.dp)
            ) {
                Text(
                    text = "Popular Products", style = TextStyle(
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "View All", style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Blue.copy(alpha = 0.5f)
                    )
                )
            }
            ItemProductSearch(
                img = R.drawable.s1,
                name = "Nike",
                price = "$1400",
                rate = "3.9",
                onClick = {})
            ItemProductSearch(
                img = R.drawable.s2,
                name = "Adidas",
                price = "$3400",
                rate = "4.9",
                onClick = {})
            ItemProductSearch(
                img = R.drawable.s3,
                name = "Ios",
                price = "$2900",
                rate = "4.5",
                onClick = {})
        }
    }
}

@Composable
fun ItemRecentSearch(
    title: String
) {
    Box(
        modifier = Modifier
            .border(
                width = 2.dp,
                color = Color.Gray.copy(alpha = 0.1f),
                shape = RoundedCornerShape(5.dp)
            )
            .padding(8.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Default.Refresh,
                contentDescription = null,
                tint = Color.Gray.copy(alpha = 0.5f)
            )
            Text(
                text = title, style = TextStyle(
                    color = Color.Gray.copy(alpha = 0.5f),
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp
                )
            )
        }
    }
}

@Preview
@Composable
fun TestItemRecentSearch() {
    ItemRecentSearch(title = "Nike Airmax")
}

@Composable
fun ItemProductSearch(
    img: Int,
    name: String,
    price: String,
    rate: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .height(100.dp)
            .fillMaxWidth()
            .padding(start = 22.dp, end = 22.dp, top = 10.dp)
            .clickable { onClick.invoke() },
        shape = RoundedCornerShape(15.dp),
        elevation = 8.dp,
        backgroundColor = Color.White
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 22.dp, end = 22.dp)
        ) {
            Box(
                modifier = Modifier
                    .background(Color.Gray.copy(alpha = 0.3f), shape = RoundedCornerShape(10.dp))
                    .width(50.dp)
                    .height(50.dp),
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
            Column(modifier = Modifier.padding(start = 10.dp)) {
                Text(
                    text = name,
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
                    )
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Box(
                modifier = Modifier
                    .background(Color.Blue.copy(alpha = 0.3f), shape = RoundedCornerShape(5.dp))
                    .height(20.dp)
                    .width(50.dp),
                contentAlignment = Alignment.Center
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = rate,
                        style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Normal)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = null,
                        tint = Color.Yellow
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun TestItemProductSearch() {
    ItemProductSearch(img = R.drawable.s1, name = "Mobius OG", price = "$1200", rate = "4.5") {

    }
}