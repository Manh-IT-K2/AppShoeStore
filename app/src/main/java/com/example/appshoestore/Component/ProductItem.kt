package com.example.appshoestore.Component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appshoestore.Model.Products
import com.example.appshoestore.R

@Preview(showBackground = true)
@Composable
fun ProductItem(
    product: Products =
        Products(
            id = "1",
            color = Color.Magenta,
            price = 1200f,
            name = "Shoes Pink",
            discount = 1000f,
            rating = 4.7f,
            imageRes = R.drawable.s1,
            size = 8
        )
) {
    var color by remember {
        mutableStateOf(product.color)
    }
    Box(
        modifier = Modifier
            .padding(20.dp)
            .size(168.dp, 210.dp)
    ) {

        var isFavorite by remember {
            mutableStateOf(false)
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .alpha(.2f)
                .background(color = color, shape = RoundedCornerShape(22.dp))
        )
        IconButton(
            onClick = {
                isFavorite = !isFavorite
            },
            modifier = Modifier.align(Alignment.TopEnd)
        ) {
            Icon(
                imageVector =
                if (isFavorite)
                    Icons.Rounded.Favorite
                else
                    Icons.Rounded.FavoriteBorder,
                contentDescription = null
            )
        }
        Text(text = product.size.toString(),
            fontWeight = FontWeight.Bold,
            color = color.copy(alpha = .3f),
            fontSize = 120.sp,
            modifier = Modifier.align(Alignment.TopCenter)
        )
        Image(painter = painterResource(id = product.imageRes), contentDescription = null,
            modifier = Modifier.fillMaxSize(1f).align(Alignment.Center).rotate(20f).offset((-20).dp,(-30).dp))

    }
}