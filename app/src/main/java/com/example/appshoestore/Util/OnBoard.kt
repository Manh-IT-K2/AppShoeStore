package com.example.appshoestore.Util

import android.content.Context

class OnBoard(private val context: Context) {

    fun isOnBoardingCompleted(): Boolean {
        return context.getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
            .getBoolean("Complete", false)
    }

    fun setOnBoardingCompleted() {
        context.getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
            .edit()
            .putBoolean("Complete", true)
            .apply()
    }
}