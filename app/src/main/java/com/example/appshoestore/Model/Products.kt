package com.example.appshoestore.Model

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class Products(
    var id: String,
    var name: String,
    var color: Color,
    var price: Float,
    var discount: Float,
    var size: Int,
    var rating: Float,
    @DrawableRes val imageRes: Int
)
