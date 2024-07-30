package com.example.appshoestore.Model

import androidx.annotation.DrawableRes
import com.example.appshoestore.R

sealed class OnBoarding(
    @DrawableRes val image: Int,
    val title: String,
    val titleMain: String,
    val description: String
) {
    data object FirstPage: OnBoarding(
        image = R.drawable.img_board_1,
        title = "Best collection of ",
        titleMain = "S-Shoe",
        description = "We are proud to offer high quality, fashionable shoes suitable for every occasion.",
    )

    data object SecondPage: OnBoarding(
        image = R.drawable.img_board_2,
        title = "Best product on the ",
        titleMain = "Market",
        description = "Explore a diverse collection of shoes, from sneakers to office shoes, helping you feel confident with every step.",
    )
    data object ThirdPage: OnBoarding(
        image = R.drawable.img_board_3,
        title = "Best offers for ",
        titleMain = "Customers",
        description = "Buy today to receive special offers, free shipping and dedicated customer service.",
    )
}