package com.example.appshoestore.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Security
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appshoestore.ui.theme.f1

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun NotificationScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(22.dp, 16.dp),
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Notifications",
                color = Color.Black,
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = f1
                ),
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = "Today", color = Color.Gray,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = f1,
                ),
                modifier = Modifier.padding(top = 20.dp)
            )
            ItemNotificationUI(
                icon = Icons.Rounded.Notifications,
                title = "Your profile picture updated successfully",
                onClick = {})
            ItemNotificationUI(
                icon = Icons.Rounded.Security,
                title = "Your password is two month old, please update it",
                onClick = {})
            ItemNotificationUI(
                icon = Icons.Rounded.Notifications,
                title = "Your profile picture updated successfully",
                onClick = {})
            ItemNotificationUI(
                icon = Icons.Rounded.Notifications,
                title = "Your profile picture updated successfully",
                onClick = {})
            ItemNotificationUI(
                icon = Icons.Rounded.Notifications,
                title = "Your profile picture updated successfully",
                onClick = {})
            ItemNotificationUI(
                icon = Icons.Rounded.Notifications,
                title = "Your profile picture updated successfully",
                onClick = {})
        }
    }
}

@Composable
fun ItemNotificationUI(
    icon: ImageVector,
    title: String,
    onClick: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ) {
        Row() {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(RoundedCornerShape(25.dp))
                    .background(color = Color.LightGray.copy(alpha = 0.5f)),
                contentAlignment = Alignment.Center,

                ) {
                Icon(imageVector = icon, contentDescription = null, tint = Color.Black)
            }
            Column(
                modifier = Modifier
                    .padding(start = 16.dp)
            ) {
                Text(
                    modifier = Modifier.clickable(onClick = onClick),
                    text = title, color = Color.Black, style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = f1
                    )
                )
                Box(modifier = Modifier.fillMaxWidth().padding(top = 6.dp), contentAlignment = Alignment.BottomEnd) {
                    Text(
                        text = "03:20 PM",
                        color = Color.Gray,
                        style = TextStyle(fontWeight = FontWeight.Normal, fontSize = 14.sp),
                    )
                }
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
fun TextItemNotificationUI() {
    ItemNotificationUI(
        icon = Icons.Rounded.Settings,
        title = "Your profile picture updated successfully",
        onClick = {})
}