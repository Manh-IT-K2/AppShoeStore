package com.example.appshoestore

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.PratikFagadiya.smoothanimationbottombar.model.SmoothAnimationBottomBarScreens
import com.PratikFagadiya.smoothanimationbottombar.properties.BottomBarProperties
import com.PratikFagadiya.smoothanimationbottombar.ui.SmoothAnimationBottomBar
import com.PratikFagadiya.smoothanimationbottombar.ui.theme.BlueTint
import com.example.appshoestore.Navigation.AppNavigationHost
import com.example.appshoestore.Navigation.NavigationItem
import com.example.appshoestore.Screen.OnBoardingScreen
import com.example.appshoestore.Util.OnBoard
import com.example.appshoestore.ui.theme.AppShoeStoreTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private val onBoardingUtils by lazy { OnBoard(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppShoeStoreTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White,
                ) {
                    if (onBoardingUtils.isOnBoardingCompleted()) {
                        BottomBar()
                    } else {
                        showOnBoardingScreen()
                    }
                }
            }
        }
    }

    @Composable
    fun showOnBoardingScreen() {
        val scope = rememberCoroutineScope()
        OnBoardingScreen {
            onBoardingUtils.setOnBoardingCompleted()
            scope.launch {
                setContent {
                   BottomBar()
                }
            }
        }
    }
}


@Composable
fun BottomBar() {
    val bottomNavigationItems = listOf(
        SmoothAnimationBottomBarScreens(
            NavigationItem.HOME,
            stringResource(id = R.string.Home),
            Icons.Default.Home
        ),
        SmoothAnimationBottomBarScreens(
            NavigationItem.PAYMENT,
            stringResource(id = R.string.Notification),
            Icons.Default.Notifications
        ),
        SmoothAnimationBottomBarScreens(
            NavigationItem.SHOPPING_CART,
            stringResource(id = R.string.Cart),
            Icons.Default.ShoppingCart
        ),
        SmoothAnimationBottomBarScreens(
            NavigationItem.SEARCH,
            stringResource(id = R.string.Cart),
            Icons.Default.Search
        ),
        SmoothAnimationBottomBarScreens(
            NavigationItem.PROFILE,
            stringResource(id = R.string.Cart),
            Icons.Default.Person
        ),
    )

    val navController = rememberNavController()
    val currentIndex = rememberSaveable {
        mutableIntStateOf(0)
    }

    Scaffold(bottomBar = {
        SmoothAnimationBottomBar(navController,
            bottomNavigationItems,
            initialIndex = currentIndex,
            bottomBarProperties = BottomBarProperties(
                backgroundColor = Color.White,
                indicatorColor = Color.Magenta.copy(alpha = 0.2F),
                iconTintColor = BlueTint,
                iconTintActiveColor = Color.Magenta,
                textActiveColor = Color.Black,
                cornerRadius = 18.dp,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp
            ),
            onSelectItem = {
                Log.i("SELECTED_ITEM", "onCreate: Selected Item ${it.name}")
            })
    }) { innerPadding ->
        Modifier.padding(innerPadding)
        AppNavigationHost(navController, currentIndex)
    }

}
