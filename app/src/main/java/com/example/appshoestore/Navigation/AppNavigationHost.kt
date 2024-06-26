package com.example.appshoestore.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.appshoestore.Screen.FavoriteScreen
import com.example.appshoestore.Screen.HomeScreen
import com.example.appshoestore.Screen.NotificationScreen
import com.example.appshoestore.Screen.ProductDetailScreen
import com.example.appshoestore.Screen.ProfileScreen
import com.example.appshoestore.Screen.SearchScreen
import com.example.appshoestore.Screen.SettingScreen
import com.example.appshoestore.Screen.ShoppingCart.ShoppingCartScreen

@Composable
fun AppNavigationHost(navController: NavHostController, currentIndex: MutableIntState) {

    NavHost(navController = navController, startDestination = NavigationItem.HOME) {

        // Home
        composable(NavigationItem.HOME) {
            HomeScreen(navController)
        }

        //Product detail
        composable(
            "${NavigationItem.PRODUCT_DETAIL}/{id}",
            arguments = listOf(navArgument("id") { type = NavType.StringType })
        ) {
            val id = it.arguments?.getString("id")
            if (id != null)
                ProductDetailScreen(id, navController)
        }

        // notification
        composable(NavigationItem.NOTIFICATION) {
            NotificationScreen()
        }

        // setting
        composable(NavigationItem.SETTING) {
            SettingScreen(navController)
        }

        // Shopping cart
        composable(NavigationItem.SHOPPING_CART) {
            ShoppingCartScreen()
        }

        // search
        composable(NavigationItem.SEARCH) {
            SearchScreen()
        }

        // profile
        composable(NavigationItem.PROFILE) {
            ProfileScreen(navController)
        }

        // favorite
        composable(NavigationItem.FAVORITE){
            FavoriteScreen(navController)
        }

    }
}
