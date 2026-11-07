package com.example.composelab.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/** Один пункт настроек: текст слева, ">" справа, на всю ширину. */
@Composable
private fun SettingsItem(title: String) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(text = title, fontSize = 17.sp, color = TextDark)
        Text(text = ">", fontSize = 18.sp, color = TextGray, fontWeight = FontWeight.Medium)
    }
}

/** 4. Экран настроек: повторяющиеся Row. */
@Composable
fun Screen04Settings() {
    ScreenRoot {
        WhiteCard(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.fillMaxWidth().padding(vertical = 12.dp)) {
                Text(
                    text = "Настройки",
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextDark,
                    modifier = Modifier.padding(start = 20.dp, top = 8.dp, bottom = 12.dp),
                )
                val items = listOf("Профиль", "Уведомления", "Приватность", "Язык", "О приложении")
                items.forEachIndexed { index, title ->
                    if (index > 0) HDivider(Modifier.padding(horizontal = 20.dp))
                    SettingsItem(title)
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun Screen04Preview() = Screen04Settings()
