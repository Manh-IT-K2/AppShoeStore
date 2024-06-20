package com.example.appshoestore.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.appshoestore.Screen.HomeScreen
import com.example.appshoestore.Screen.ProductDetailScreen

@Composable
fun AppNavigationHost(
    modifier: Modifier = Modifier,
    startDestination: String = NavigationItem.PRODUCT
) {
    val navController = rememberNavController()
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavigationItem.PRODUCT) {
            HomeScreen(navController)
        }
        composable(
            "${NavigationItem.PRODUCT_DETAIL}/{id}",
            arguments = listOf(navArgument("id") { type = NavType.StringType })
        ) {
            val id = it.arguments?.getString("id")
            if (id != null)
                ProductDetailScreen(id, navController)
        }
    }
}

