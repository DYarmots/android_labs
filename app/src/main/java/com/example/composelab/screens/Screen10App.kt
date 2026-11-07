package com.example.composelab.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Green = Color(0xFF1F9D55)

@Composable
private fun RowScope.StatTile(value: String, label: String) {
    WhiteCard(modifier = Modifier.weight(1f), corner = 16.dp) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(vertical = 14.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(text = value, fontSize = 26.sp, fontWeight = FontWeight.Bold, color = TextDark)
            Text(text = label, fontSize = 12.sp, color = TextGray)
        }
    }
}

@Composable
private fun ActivityRow(order: String, amount: String) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Avatar(size = 32.dp)
        Text(
            text = order,
            fontSize = 14.sp,
            color = TextDark,
            modifier = Modifier.weight(1f),
        )
        Text(text = amount, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Green)
    }
}

/** 10. Финальный экран: Row/Column/Card/Box/Text, 3+ уровня вложенности, адаптивность по ширине. */
@Composable
fun Screen10App() {
    ScreenRoot {
        // Приветствие
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "Good morning, Alex",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = TextDark,
                modifier = Modifier.weight(1f),
            )
            Box(
                modifier = Modifier.size(34.dp).clip(RoundedCornerShape(10.dp)).background(Color.White),
                contentAlignment = Alignment.Center,
            ) {
                Text(text = "🔔", fontSize = 16.sp)
            }
        }

        // Баланс с декоративными Box
        WhiteCard(modifier = Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Brush.linearGradient(listOf(Color(0xFFEAF1FF), Color(0xFFD9F5E8)))),
            ) {
                Box(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .offset(x = 30.dp, y = (-30).dp)
                        .size(120.dp)
                        .clip(CircleShape)
                        .background(Color.White.copy(alpha = 0.5f)),
                )
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .offset(x = (-20).dp, y = 30.dp)
                        .size(80.dp)
                        .clip(CircleShape)
                        .background(Green.copy(alpha = 0.12f)),
                )
                Column(modifier = Modifier.fillMaxWidth().padding(20.dp)) {
                    Text(text = "Your balance", fontSize = 13.sp, color = TextGray)
                    Text(
                        text = "124 500 ₽",
                        fontSize = 32.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = TextDark,
                        modifier = Modifier.padding(top = 4.dp),
                    )
                    Text(text = "+12.5%", fontSize = 13.sp, fontWeight = FontWeight.Medium, color = Green)
                }
            }
        }

        // Статистика
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            Text(text = "Statistics", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = TextDark)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                StatTile("128", "Orders")
                StatTile("82%", "Conversion")
            }
        }

        // Последняя активность
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            Text(text = "Recent activity", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = TextDark)
            WhiteCard(modifier = Modifier.fillMaxWidth(), corner = 16.dp) {
                Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 4.dp)) {
                    ActivityRow("Order #123", "+4 500 ₽")
                    HDivider()
                    ActivityRow("Order #122", "+2 300 ₽")
                    HDivider()
                    ActivityRow("Order #121", "+8 900 ₽")
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun Screen10Preview() = Screen10App()
