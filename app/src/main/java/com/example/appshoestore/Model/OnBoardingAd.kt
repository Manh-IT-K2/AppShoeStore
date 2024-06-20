package com.example.appshoestore.Model

import androidx.annotation.DrawableRes
import com.example.appshoestore.R

sealed class OnBoardingAd(
    @DrawableRes val image: Int
) {
    data object AdOne : OnBoardingAd(
        image = R.drawable.ad_1
    )

    data object AdTwo : OnBoardingAd(
        image = R.drawable.ad_2
    )

    data object AdThree : OnBoardingAd(
        image = R.drawable.ad_3
    )
}