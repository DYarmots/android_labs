package com.example.composelab.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/** 1. Профиль пользователя: Card + Column + Row. */
@Composable
fun Screen01Profile() {
    ScreenRoot {
        WhiteCard(modifier = Modifier.fillMaxWidth(0.92f)) {
            Column(
                modifier = Modifier.fillMaxWidth().padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Avatar(size = 96.dp)
                Text(
                    text = "Алексей",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextDark,
                    modifier = Modifier.padding(top = 16.dp),
                )
                Text(text = "Android Dev", fontSize = 15.sp, color = TextGray)

                Row(
                    modifier = Modifier.fillMaxWidth().padding(top = 24.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(text = "📍 Москва", fontSize = 14.sp, color = TextGray)
                    Box(modifier = Modifier.width(1.dp).height(22.dp).background(LineGray))
                    Text(text = "📅 25 лет", fontSize = 14.sp, color = TextGray)
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun Screen01Preview() = Screen01Profile()
