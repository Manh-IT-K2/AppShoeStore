package com.example.appshoestore.Screen

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.ArrowRight
import androidx.compose.material.icons.outlined.Help
import androidx.compose.material.icons.outlined.Language
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.rounded.Key
import androidx.compose.material.icons.rounded.Keyboard
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appshoestore.ui.theme.f1
import com.example.appshoestore.ui.theme.f10
import com.example.appshoestore.ui.theme.f2
import com.example.appshoestore.ui.theme.f3
import com.example.appshoestore.ui.theme.f4
import com.example.appshoestore.ui.theme.f5
import com.example.appshoestore.ui.theme.f6
import com.example.appshoestore.ui.theme.f7
import com.example.appshoestore.ui.theme.f8
import com.example.appshoestore.ui.theme.f9

@Composable
fun SettingScreen(navController: NavController) {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(Modifier.fillMaxSize()) {
            Row(Modifier.fillMaxWidth()) {
                Box(Modifier.weight(1f)) {
                    IconButton(
                        onClick = {navController.popBackStack()},
                        modifier = Modifier
                            .padding(start = 22.dp, top = 16.dp)
                            .shadow(
                                elevation = 24.dp,
                                spotColor = DefaultShadowColor,
                                shape = RoundedCornerShape(12.dp)
                            )
                            .background(color = Color.White, shape = RoundedCornerShape(22.dp))
                            .size(36.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.KeyboardArrowLeft,
                            contentDescription = null,
                            tint = Color.Black
                        )
                    }
                }
                Box(Modifier.weight(1f), contentAlignment = Alignment.Center) {
                    Text(
                        text = "Settings",
                        color = Color.Black,
                        style = TextStyle(
                            fontFamily = f1,
                            fontWeight = FontWeight.Bold,
                            fontSize = 22.sp,
                        ),
                        modifier = Modifier.padding(top = 16.dp)
                    )
                }
                Box(modifier = Modifier.weight(1f))
            }
            Spacer(modifier = Modifier.height(30.dp))
            ItemSetting(icon = Icons.Outlined.Person, title = "Account", description = "Privacy, Security")
            ItemSetting(icon = Icons.Outlined.Language, title = "Language", description = "English")
            ItemSetting(icon = Icons.Outlined.Notifications, title = "Notifications", description = "Messages")
            ItemSetting(icon = Icons.Outlined.Help, title = "Help", description = "Contact us, Privacy policy")
        }
    }
}

@Composable
fun ItemSetting(
    icon: ImageVector,
    title: String,
    description: String,
    iconDetail: ImageVector = Icons.Default.ArrowForwardIos,
) {
    Box(
        modifier = Modifier
            .padding(22.dp, 16.dp)
            .fillMaxWidth()
            .background(Color.Transparent)
    ) {
        Column {
            Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.padding(bottom = 10.dp)) {
                Icon(imageVector = icon, contentDescription = null, Modifier.size(30.dp), tint = Color.Black)
                Column(Modifier.padding(start = 16.dp)) {
                    Text(
                        text = title,
                        color = Color.Black,
                        fontSize = 16.sp,
                        style = TextStyle(
                            fontWeight = FontWeight.Normal,
                            fontFamily = f1
                        )
                    )
                    Text(
                        text = description,
                        color = Color.Gray,
                        fontSize = 16.sp,
                        style = TextStyle(
                            fontWeight = FontWeight.Normal,
                        )
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Icon(imageVector = iconDetail, contentDescription = null, tint = Color.Black)
            }
            Box(
                modifier = Modifier
                    .width(400.dp)
                    .height(1.dp)
                    .background(Color.LightGray.copy(alpha = 0.5f))
            )
        }
    }
}

@Preview
@Composable
fun testViewItemSetting() {
    ItemSetting(icon = Icons.Outlined.Person, title = "Account", description = "Privacy, Security")
}