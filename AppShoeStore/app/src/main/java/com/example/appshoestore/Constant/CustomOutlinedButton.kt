package com.example.appshoestore.Constant

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appshoestore.R

@Composable
fun CustomOutlinedButton(
    title: String,
    icon: Int,
    modifier: Modifier,
    onClick: () -> Unit = {}
) {
    OutlinedButton(
        onClick = onClick,
        border = BorderStroke(1.dp, Color.Gray.copy(alpha = 0.5f)),
        colors = ButtonDefaults.outlinedButtonColors(
            backgroundColor = Color.Transparent,
        ),
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.size(25.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            title, style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black
            )
        )
    }
}


@Preview
@Composable
fun PreviewCustomOutlinedTextFieldApp() {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        CustomOutlinedButton(title = "Google", icon = R.drawable.icon_google, modifier = Modifier.padding(8.dp))
    }
}