package com.example.appshoestore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.appshoestore.Navigation.AppNavigationHost
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
                    color = Color.LightGray
                ) {
                    if(onBoardingUtils.isOnBoardingCompleted()){
                        AppNavigationHost()
                    }else{
                        showOnBoardingScreen()
                    }
                }
            }
        }
    }
    @Composable
    fun showOnBoardingScreen(){
        val scope = rememberCoroutineScope()
        OnBoardingScreen {
            onBoardingUtils.setOnBoardingCompleted()
            scope.launch {
                setContent {
                    AppNavigationHost()
                }
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun GreetingPreview() {
    AppShoeStoreTheme {
        Greeting("Android")
    }
}
