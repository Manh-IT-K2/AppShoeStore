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
import com.example.appshoestore.Screen.CongratulationScreen
import com.example.appshoestore.Screen.FavoriteScreen
import com.example.appshoestore.Screen.ForgotPasswordScreen
import com.example.appshoestore.Screen.HomeScreen
import com.example.appshoestore.Screen.LoginScreen
import com.example.appshoestore.Screen.NewPasswordScreen
import com.example.appshoestore.Screen.NotificationScreen
import com.example.appshoestore.Screen.OtpVerificationScreen
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
import com.example.appshoestore.Screen.SignupScreen

@Composable
fun AppNavigationHost(navController: NavHostController, currentIndex: MutableIntState) {


    NavHost(navController = navController, startDestination = NavigationItem.LOGIN) {

        // Home
        composable(NavigationItem.HOME) {
            HomeScreen(navController)
        }

        // sign up
        composable(NavigationItem.SIGNUP){
            SignupScreen(navController)
        }

        // login
        composable(NavigationItem.LOGIN){
            LoginScreen(navController)
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
            NotificationScreen(navController)
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
            SearchScreen(navController)
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

        // forgot password
        composable(NavigationItem.FORGOT_PASSWORD){
            ForgotPasswordScreen(navController)
        }

        // otp
        composable(NavigationItem.OTP){
            OtpVerificationScreen(navController)
        }

        // new password
        composable(NavigationItem.NEW_PASSWORD){
            NewPasswordScreen(navController)
        }

        // congratulation
        composable(NavigationItem.CONGRATULATION){
            CongratulationScreen(navController)
        }

    }
}
