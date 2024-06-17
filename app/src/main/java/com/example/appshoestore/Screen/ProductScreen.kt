package com.example.appshoestore.Screen

import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.graphics.Shader
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.FloatingActionButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asComposeRenderEffect
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appshoestore.Component.ProductItem
import com.example.appshoestore.MainActivity
import com.example.appshoestore.Model.Products
import com.example.appshoestore.Navigation.NavigationItem
import com.example.appshoestore.R
import com.example.appshoestore.Util.times
import com.example.appshoestore.Util.transform
import com.example.appshoestore.ui.theme.AppShoeStoreTheme
import com.example.appshoestore.ui.theme.DEFAULT_PADDING
import com.example.appshoestore.ui.theme.f1
import com.example.appshoestore.ui.theme.f2
import com.example.appshoestore.ui.theme.f3
import com.example.appshoestore.ui.theme.f4
import com.example.appshoestore.ui.theme.f5
import kotlin.math.PI
import kotlin.math.sin

@Composable
fun ProductScreen(navController: NavController) {
    var products = remember {
        getProductList()
    }
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(top = 6.dp, bottom = 6.dp)
    ){
        Column {
            headerScreen()
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .padding(8.dp)
                    .padding(bottom = 70.dp)
            ) {
                items(products) {
                    ProductItem(product = it) {
                        navController.navigate("${NavigationItem.PRODUCT_DETAIL}/${it.id}")
                    }
                }
            }
        }
        MainScreen()
    }


}


@Composable
fun headerScreen() {
    Box(
        modifier = Modifier
            .padding(top = 16.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 22.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Hi!, QManh",
                    color = Color.Black,
                    fontSize = 12.sp,
                    style = TextStyle(
                        fontFamily = f1,
                        fontWeight = FontWeight.Normal,
                        platformStyle = PlatformTextStyle(includeFontPadding = false)
                    )
                )
                Text(
                    text = "Let's order your \nfavorite shoes",
                    color = Color.Black,
                    fontSize = 22.sp,
                    style = TextStyle(
                        platformStyle = PlatformTextStyle(includeFontPadding = false),
                        fontWeight = FontWeight.Light,
                        fontFamily = f1
                    ),
                    modifier = Modifier.padding(top = 5.dp)
                )
            }

            Box(
                modifier = Modifier
                    .size(60.dp) // Kích thước của hình ảnh
                    .clip(CircleShape) // Cắt hình ảnh theo hình tròn
                    .border(2.dp, Color.White, CircleShape), // Viền màu trắng và dày 2 dp
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.user), // Thay thế bằng ID của hình ảnh của bạn
                    contentDescription = null,
                    contentScale = ContentScale.Crop, // Đảm bảo hình ảnh được cắt theo khung
                    modifier = Modifier
                        .matchParentSize() // Đảm bảo hình ảnh chiếm toàn bộ không gian của Box
                        .clip(CircleShape) // Đảm bảo hình ảnh cũng được cắt theo hình tròn
                )
            }
        }
    }

}

@RequiresApi(Build.VERSION_CODES.S)
private fun getRenderEffect(): android.graphics.RenderEffect {
    val blurEffect = android.graphics.RenderEffect
        .createBlurEffect(80f, 80f, Shader.TileMode.MIRROR)

    val alphaMatrix = android.graphics.RenderEffect.createColorFilterEffect(
        ColorMatrixColorFilter(
            ColorMatrix(
                floatArrayOf(
                    1f, 0f, 0f, 0f, 0f,
                    0f, 1f, 0f, 0f, 0f,
                    0f, 0f, 1f, 0f, 0f,
                    0f, 0f, 0f, 50f, -5000f
                )
            )
        )
    )

    return android.graphics.RenderEffect
        .createChainEffect(alphaMatrix, blurEffect)
}

@Composable
fun MainScreen() {
    val isMenuExtended = remember { mutableStateOf(false) }

    val fabAnimationProgress by animateFloatAsState(
        targetValue = if (isMenuExtended.value) 1f else 0f,
        animationSpec = tween(
            durationMillis = 1000,
            easing = LinearEasing
        )
    )

    val clickAnimationProgress by animateFloatAsState(
        targetValue = if (isMenuExtended.value) 1f else 0f,
        animationSpec = tween(
            durationMillis = 400,
            easing = LinearEasing
        )
    )

    val renderEffect = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        getRenderEffect().asComposeRenderEffect()
    } else {
        null
    }

    MainScreen(
        renderEffect = renderEffect,
        fabAnimationProgress = fabAnimationProgress,
        clickAnimationProgress = clickAnimationProgress
    ) {
        isMenuExtended.value = isMenuExtended.value.not()
    }
}

@Composable
fun MainScreen(
    renderEffect: androidx.compose.ui.graphics.RenderEffect?,
    fabAnimationProgress: Float = 0f,
    clickAnimationProgress: Float = 0f,
    toggleAnimation: () -> Unit = { }
) {
    Box(
        Modifier
            .fillMaxSize()
            .padding(bottom = 8.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        CustomBottomNavigation()
        Circle(
            color = MaterialTheme.colors.primary.copy(alpha = 0.5f),
            animationProgress = 0.5f
        )

        FabGroup(renderEffect = renderEffect, animationProgress = fabAnimationProgress)
        FabGroup(
            renderEffect = null,
            animationProgress = fabAnimationProgress,
            toggleAnimation = toggleAnimation
        )
        Circle(
            color = Color.White,
            animationProgress = clickAnimationProgress
        )
    }
}

@Composable
fun Circle(color: Color, animationProgress: Float) {
    val animationValue = sin(PI * animationProgress).toFloat()

    Box(
        modifier = Modifier
            .padding(DEFAULT_PADDING.dp)
            .size(56.dp)
            .scale(2 - animationValue)
            .border(
                width = 2.dp,
                color = color.copy(alpha = color.alpha * animationValue),
                shape = CircleShape
            )
    )
}

@Composable
fun CustomBottomNavigation() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .height(80.dp)
            .paint(
                painter = painterResource(R.drawable.bottom_navigation),
                contentScale = ContentScale.FillHeight
            )
            .padding(horizontal = 40.dp)
    ) {
        listOf(Icons.Filled.Search, Icons.Filled.Group).map { image ->
            IconButton(onClick = { }) {
                Icon(imageVector = image, contentDescription = null, tint = Color.White)
            }
        }
    }
}

@Composable
fun FabGroup(
    animationProgress: Float = 0f,
    renderEffect: androidx.compose.ui.graphics.RenderEffect? = null,
    toggleAnimation: () -> Unit = { }
) {
    Box(
        Modifier
            .fillMaxSize()
            .graphicsLayer { this.renderEffect = renderEffect }
            .padding(bottom = DEFAULT_PADDING.dp),
        contentAlignment = Alignment.BottomCenter
    ) {

        AnimatedFab(
            icon = Icons.Default.Notifications,
            modifier = Modifier
                .padding(
                    PaddingValues(
                        bottom = 72.dp,
                        end = 210.dp
                    ) * FastOutSlowInEasing.transform(0f, 0.8f, animationProgress)
                ),
            opacity = LinearEasing.transform(0.2f, 0.7f, animationProgress)
        )

        AnimatedFab(
            icon = Icons.Default.ShoppingCart,
            modifier = Modifier.padding(
                PaddingValues(
                    bottom = 88.dp,
                ) * FastOutSlowInEasing.transform(0.1f, 0.9f, animationProgress)
            ),
            opacity = LinearEasing.transform(0.3f, 0.8f, animationProgress)
        )

        AnimatedFab(
            icon = Icons.Default.Settings,
            modifier = Modifier.padding(
                PaddingValues(
                    bottom = 72.dp,
                    start = 210.dp
                ) * FastOutSlowInEasing.transform(0.2f, 1.0f, animationProgress)
            ),
            opacity = LinearEasing.transform(0.4f, 0.9f, animationProgress)
        )

        AnimatedFab(
            modifier = Modifier
                .scale(1f - LinearEasing.transform(0.5f, 0.85f, animationProgress)),
        )

        AnimatedFab(
            icon = Icons.Default.Add,
            modifier = Modifier
                .rotate(
                    225 * FastOutSlowInEasing
                        .transform(0.35f, 0.65f, animationProgress)
                ),
            onClick = toggleAnimation,
            backgroundColor = Color.Transparent
        )
    }
}

@Composable
fun AnimatedFab(
    modifier: Modifier,
    icon: ImageVector? = null,
    opacity: Float = 1f,
    backgroundColor: Color = MaterialTheme.colors.secondary,
    onClick: () -> Unit = {}
) {
    FloatingActionButton(
        onClick = onClick,
        elevation = FloatingActionButtonDefaults.elevation(0.dp, 0.dp, 0.dp, 0.dp),
        backgroundColor = backgroundColor,
        modifier = modifier.scale(1.25f)
    ) {
        icon?.let {
            Icon(
                imageVector = it,
                contentDescription = null,
                tint = Color.White.copy(alpha = opacity)
            )
        }
    }
}


//@Composable
//@Preview(device = "id:pixel_4a", showBackground = true, backgroundColor = 0xFFFFFFFF)
//private fun MainScreenPreview() {
//    AppShoeStoreTheme {
//        MainActivity()
//    }
//}

fun getProductList(): List<Products> {
    return listOf(
        Products(
            id = "1",
            color = Color.Blue,
            price = 1200f,
            name = "Shoes Blue",
            discount = 1000f,
            rating = 4.7f,
            imageRes = R.drawable.s1,
            size = 8
        ),
        Products(
            id = "2",
            color = Color.Magenta,
            price = 1200f,
            name = "Shoes Pink",
            discount = 1000f,
            rating = 4.7f,
            imageRes = R.drawable.s2,
            size = 8
        ),
        Products(
            id = "3",
            color = Color(0xFF8B784D),
            price = 1200f,
            name = "Shoes Dark Yellow",
            discount = 1000f,
            rating = 4.7f,
            imageRes = R.drawable.s3,
            size = 8
        ),
        Products(
            id = "4",
            color = Color.Red,
            price = 1200f,
            name = "Shoes Red",
            discount = 1000f,
            rating = 4.7f,
            imageRes = R.drawable.s4,
            size = 8
        ),
        Products(
            id = "5",
            color = Color(0xFFA66842),
            price = 1200f,
            name = "Shoes Brown",
            discount = 1000f,
            rating = 4.7f,
            imageRes = R.drawable.s5,
            size = 8
        ),
        Products(
            id = "6",
            color = Color.Gray,
            price = 1200f,
            name = "Shoes Gray",
            discount = 1000f,
            rating = 4.7f,
            imageRes = R.drawable.s6,
            size = 8
        ),
        Products(
            id = "7",
            color = Color(0xFFBE8726),
            price = 1200f,
            name = "Shoes Yellow",
            discount = 1000f,
            rating = 4.7f,
            imageRes = R.drawable.s7,
            size = 8
        ),
        Products(
            id = "8",
            color = Color.Green,
            price = 1200f,
            name = "Shoes Green",
            discount = 1000f,
            rating = 4.7f,
            imageRes = R.drawable.s8,
            size = 8
        )
    )
}
