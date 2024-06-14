package com.example.appshoestore.Screen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.appshoestore.Component.ProductItem
import com.example.appshoestore.Model.Products
import com.example.appshoestore.R

@Composable
fun ProductScreen() {
    var products = remember {
        getProductList()
    }
    LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = Modifier.padding(8.dp)){
        items(products){
            ProductItem(product = it)
        }
    }
}

fun getProductList() : List<Products>{
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
            name = "Shoes Pink",
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
            color = Color.Gray,
            price = 1200f,
            name = "Shoes Brown",
            discount = 1000f,
            rating = 4.7f,
            imageRes = R.drawable.s5,
            size = 8
        ),
        Products(
            id = "6",
            color = Color(0xFFA66842),
            price = 1200f,
            name = "Shoes Pink",
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
        )
    )
}