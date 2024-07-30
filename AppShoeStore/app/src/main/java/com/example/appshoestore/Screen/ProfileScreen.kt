package com.example.appshoestore.Screen

import android.graphics.drawable.Icon
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.rounded.CameraAlt
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.PrivacyTip
import androidx.compose.material.icons.rounded.Schedule
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appshoestore.Navigation.NavigationItem
import com.example.appshoestore.R
import com.example.appshoestore.ui.theme.f1

@OptIn(ExperimentalComposeUiApi::class)
//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfileScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(22.dp, 16.dp),
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "ProfileScreen",
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = f1
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                val (imageUser, edit) = createRefs()
                Box(
                    modifier = Modifier
                        .size(70.dp)
                        .clip(CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.user),
                        contentDescription = null,
                        modifier = Modifier
                            .size(60.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )
                    IconButton(
                        onClick = { /* Xử lý sự kiện chỉnh sửa */ },
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(8.dp)
                            .size(20.dp)
                            .background(Color.Transparent, shape = CircleShape)
                            .clip(CircleShape)
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.CameraAlt,
                            contentDescription = null,
                            tint = Color.Black
                        )
                    }
                }
                Column(modifier = Modifier.padding(start = 10.dp)) {
                    Text(
                        text = "Quan Van Manh",
                        color = Color.Black,
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = f1,
                            textAlign = TextAlign.Center
                        )
                    )
                    Text(
                        text = "quanmanh901@gmail.com",
                        color = Color.DarkGray,
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = f1,
                            textAlign = TextAlign.Center
                        )
                    )
                }
            }
            Text(
                text = "General", color = Color.Gray,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = f1,
                ),
                modifier = Modifier.padding(top = 20.dp)
            )
            ItemProfileUI(
                icon = Icons.Rounded.Settings,
                title = "Settings",
                onClick = {
                    Log.d("manh", "manh")
                    navController.navigate(NavigationItem.SETTING)
                }
            )
            ItemProfileUI(icon = Icons.Rounded.Favorite, title = "Favorites", onClick = {
                navController.navigate(NavigationItem.FAVORITE)
            })
            ItemProfileUI(icon = Icons.Rounded.Schedule, title = "Order History", onClick = {})
            Text(
                text = "Security", color = Color.Gray,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = f1,
                ),
                modifier = Modifier.padding(top = 20.dp)
            )
            ItemProfileUI(icon = Icons.Rounded.PrivacyTip, title = "Privacy Policy", onClick = {})
            ItemProfileUI(icon = Icons.Rounded.Info, title = "Terms & Conditions", onClick = {})
        }
    }
}

@Composable
fun ItemProfileUI(
    icon: ImageVector,
    title: String,
    onClick: () -> Unit
) {

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 16.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(RoundedCornerShape(15.dp))
                    .background(color = Color.LightGray.copy(alpha = 0.5f)),
                contentAlignment = Alignment.Center,

                ) {
                Icon(imageVector = icon, contentDescription = null, tint = Color.Black)
            }
            Text(
                text = title, color = Color.Black, style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = f1
                ),
                modifier = Modifier.padding(start = 10.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = {   onClick() }) {
                Icon(imageVector = Icons.Default.ArrowForwardIos, contentDescription = null, tint = Color.Black)
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Box(
            modifier = Modifier
                .background(Color.LightGray.copy(alpha = 0.5f))
                .width(400.dp)
                .height(1.dp)
        )
    }

}

@Preview
@Composable
fun testUIItem() {
    ItemProfileUI(icon = Icons.Rounded.Settings, title = "Setting", onClick = {})
}