package com.example.appshoestore.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun SearchScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White).padding(top = 22.dp),
        //contentAlignment = Alignment.Center
    ) {
        Column() {
//            IconButton(
//                onClick = { /*TODO*/ },
//                modifier = Modifier
//                    .padding(16.dp, 16.dp)
//                    .shadow(
//                        elevation = 24.dp,
//                        spotColor = DefaultShadowColor,
//                        shape = RoundedCornerShape(12.dp)
//                    )
//                    .background(color = Color.White, shape = RoundedCornerShape(22.dp))
//            ) {
//                Icon(
//                    imageVector = Icons.Rounded.KeyboardArrowLeft,
//                    contentDescription = null,
//                    tint = Color.Black
//                )
//            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(horizontal = 16.dp)
                    .background(Color.Gray.copy(alpha = 0.2f), shape = RoundedCornerShape(10.dp))
                    ,
                contentAlignment = Alignment.CenterStart
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
            Row(Modifier.padding(horizontal = 16.dp).padding(top = 22.dp, bottom = 16.dp)) {
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
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(items) { item ->
                    ItemRecentSearch(title = item)
                }
            }
        }
    }
}

@Composable
fun ItemRecentSearch(
    title: String
){
    Box( modifier = Modifier
        .border(width = 2.dp, color = Color.Gray.copy(alpha = 0.1f), shape = RoundedCornerShape(5.dp))
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
fun TestItemRecentSearch(){
    ItemRecentSearch(title = "Nike Airmax")
}