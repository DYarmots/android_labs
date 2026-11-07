package com.example.composelab.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
private fun RowScope.StatBox(value: String, label: String) {
    Box(
        modifier = Modifier
            .weight(1f)
            .border(1.dp, LineGray, RoundedCornerShape(12.dp))
            .padding(vertical = 10.dp),
        contentAlignment = Alignment.Center,
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = value, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = TextDark)
            Text(text = label, fontSize = 11.sp, color = TextGray)
        }
    }
}

/** 9. Профиль + статистика + информация: Card → Column → Row/Column → Card (4 уровня). */
@Composable
fun Screen09ProfileInfo() {
    ScreenRoot {
        WhiteCard(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier.fillMaxWidth().padding(18.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                // Шапка: аватар + имя
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(14.dp),
                ) {
                    Avatar(size = 60.dp)
                    Column {
                        Text(
                            text = "Алексей Иванов",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = TextDark,
                        )
                        Text(text = "Android Developer", fontSize = 13.sp, color = TextGray)
                    }
                }

                // Статистика
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                ) {
                    StatBox("24", "Projects")
                    StatBox("18", "Followers")
                    StatBox("7", "Posts")
                }

                // About
                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Text(text = "About", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = TextDark)
                    Text(text = "Android developer from Moscow", fontSize = 13.sp, color = TextGray)
                    Text(text = "Kotlin enthusiast", fontSize = 13.sp, color = TextGray)
                }

                // Experience
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(text = "Experience", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = TextDark)
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F7FC)),
                    ) {
                        Column(modifier = Modifier.fillMaxWidth().padding(12.dp)) {
                            Text(
                                text = "Android Developer",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium,
                                color = TextDark,
                            )
                            Text(text = "2022 — Present", fontSize = 12.sp, color = TextGray)
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun Screen09Preview() = Screen09ProfileInfo()
