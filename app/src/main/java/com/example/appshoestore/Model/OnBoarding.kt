package com.example.appshoestore.Model

import androidx.annotation.DrawableRes
import com.example.appshoestore.R

sealed class OnBoarding(
    @DrawableRes val image: Int,
    val title: String,
    val description: String
) {
    data object FirstPage: OnBoarding(
        image = R.drawable.img_board_1,
        title = "Best collection of Sneakers",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fringilla in sed risus sit.",
    )

    data object SecondPage: OnBoarding(
        image = R.drawable.img_board_2,
        title = "Best collection of Sneakers",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fringilla in sed risus sit.",
    )
    data object ThirdPage: OnBoarding(
        image = R.drawable.img_board_3,
        title = "Best collection of Sneakers",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fringilla in sed risus sit.",
    )
}