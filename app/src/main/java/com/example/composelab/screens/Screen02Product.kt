package com.example.composelab.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/** 2. Карточка товара: вложенные блоки и размеры. */
@Composable
fun Screen02Product() {
    ScreenRoot {
        WhiteCard(modifier = Modifier.fillMaxWidth(0.92f)) {
            Column(modifier = Modifier.padding(16.dp)) {
                // Заглушка под фото высотой 120dp
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                        .clip(RoundedCornerShape(14.dp))
                        .background(Color(0xFFDCE4F7)),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = "PHOTO\n120 dp",
                        textAlign = TextAlign.Center,
                        color = Color(0xFF7C88A8),
                        fontSize = 13.sp,
                        letterSpacing = 1.sp,
                    )
                }

                Column(modifier = Modifier.padding(top = 14.dp)) {
                    Text(
                        text = "MacBook Air",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextDark,
                    )
                    Text(text = "Ноутбук Apple", fontSize = 14.sp, color = TextGray)
                }

                Row(
                    modifier = Modifier.fillMaxWidth().padding(top = 14.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = "129 990 ₽",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = TextDark,
                    )
                    Badge(text = "В наличии")
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun Screen02Preview() = Screen02Product()
