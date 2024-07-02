package com.example.appshoestore.Constant

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ItemTextOrderSummary(
    title: String,
    price: String,
    color: Color,
    fontWeight1: FontWeight,
    fontWeight2: FontWeight,
    fontSize: TextUnit
) {
    Row(
        modifier = Modifier.padding(top = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            style = TextStyle(
                fontSize = fontSize,
                fontWeight = fontWeight1,
                color = color
            )
        )
        Text(
            text = price,
            style = TextStyle(
                fontSize = fontSize,
                fontWeight = fontWeight2,
                color = color,
                textAlign = TextAlign.End
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview
@Composable
fun PreviewItemTextOrderSummary(){
    ItemTextOrderSummary(
        title = "Grand Total",
        price = "$3130",
        color = Color.Black,
        fontWeight1 = FontWeight.Bold,
        fontWeight2 = FontWeight.Bold,
        fontSize = 18.sp
    )
}