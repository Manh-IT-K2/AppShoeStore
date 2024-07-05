package com.example.appshoestore.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.Navigation
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
import com.example.appshoestore.Screen.ShoppingCart.FullOrderDetailScreen
import com.example.appshoestore.Screen.ShoppingCart.MyOrderScreen
import com.example.appshoestore.Screen.ShoppingCart.OrderPlacedDetailScreen
import com.example.appshoestore.Screen.ShoppingCart.OrderSummaryScreen
import com.example.appshoestore.Screen.ShoppingCart.PaymentMethodScreen
import com.example.appshoestore.Screen.ShoppingCart.PaymentSuccessfullyScreen
import com.example.appshoestore.Screen.ShoppingCart.ShippingAddressScreen
import com.example.appshoestore.Screen.ShoppingCart.ShoppingCartScreen

@Composable
fun AppNavigationHost(navController: NavHostController, currentIndex: MutableIntState) {

    // Khai báo state cho bottom sheet
    var showBottomSheet by remember { mutableStateOf(false) }

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
            ShoppingCartScreen(navController)
        }

        // search
        composable(NavigationItem.SEARCH) {
            SearchScreen(openBottomSheet= {})
        }


        // profile
        composable(NavigationItem.PROFILE) {
            ProfileScreen(navController)
        }

        // favorite
        composable(NavigationItem.FAVORITE){
            FavoriteScreen(navController)
        }

        // shipping address
        composable(NavigationItem.SHIPPING){
            ShippingAddressScreen(navController)
        }

        // payment method
        composable(NavigationItem.PAYMENT){
            PaymentMethodScreen(navController)
        }

        // order summary
        composable(NavigationItem.ORDER_SUMMARY){
            OrderSummaryScreen(navController)
        }

        // full order detail
        composable(NavigationItem.FULL_ORDER_DETAIL){
            FullOrderDetailScreen(navController)
        }

        // order placed detail
        composable(NavigationItem.ORDER_PLACED_DETAIL){
            OrderPlacedDetailScreen(navController)
        }

        // payment success
        composable(NavigationItem.PAYMENT_SUCCESS){
            PaymentSuccessfullyScreen(navController)
        }

        // order detail
        composable(NavigationItem.ORDER_DETAIL){
            MyOrderScreen(navController)
        }

    }
    // Hiển thị bottom sheet ngoài NavHost
    if (showBottomSheet) {
        LaunchedEffect(navController) {
            // Xử lý logic mở bottom sheet ở đây
            showBottomSheet = false // Đặt lại trạng thái sau khi mở
        }
    }
}
