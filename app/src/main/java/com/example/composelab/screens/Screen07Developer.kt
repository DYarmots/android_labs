package com.example.composelab.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
private fun RowScope.Metric(value: String, label: String) {
    Box(
        modifier = Modifier
            .weight(1f)
            .clip(RoundedCornerShape(12.dp))
            .border(1.dp, LineGray, RoundedCornerShape(12.dp))
            .padding(vertical = 12.dp),
        contentAlignment = Alignment.Center,
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = value, fontSize = 22.sp, fontWeight = FontWeight.Bold, color = TextDark)
            Text(text = label, fontSize = 12.sp, color = TextGray)
        }
    }
}

/** 7. Профиль разработчика: всё внутри одной Card. */
@Composable
fun Screen07Developer() {
    ScreenRoot {
        WhiteCard(modifier = Modifier.fillMaxWidth(0.94f)) {
            Column(
                modifier = Modifier.fillMaxWidth().padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(18.dp),
            ) {
                // Верхняя часть
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Avatar(size = 80.dp, glyph = "👨‍💻", bg = Color(0xFFC9CCF5))
                    Text(
                        text = "DEVELOPER",
                        fontSize = 11.sp,
                        letterSpacing = 2.sp,
                        color = TextGray,
                        modifier = Modifier.padding(top = 10.dp),
                    )
                    Text(
                        text = "Алексей Иванов",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextDark,
                    )
                    Text(text = "Android Developer", fontSize = 14.sp, color = TextGray)
                }

                // Статистика
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                ) {
                    Metric("24", "Projects")
                    Metric("8", "GitHub")
                    Metric("15", "Apps")
                }

                // Навыки
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(14.dp))
                        .background(Color(0xFFE4E8FB))
                        .padding(vertical = 12.dp),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = "Kotlin  •  Android  •  Compose",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFF4A5BC4),
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun Screen07Preview() = Screen07Developer()
