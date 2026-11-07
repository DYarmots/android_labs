package com.example.composelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composelab.screens.Screen01Profile
import com.example.composelab.screens.Screen02Product
import com.example.composelab.screens.Screen03Stats
import com.example.composelab.screens.Screen04Settings
import com.example.composelab.screens.Screen05Dashboard
import com.example.composelab.screens.Screen06Order
import com.example.composelab.screens.Screen07Developer
import com.example.composelab.screens.Screen08BankCard
import com.example.composelab.screens.Screen09ProfileInfo
import com.example.composelab.screens.Screen10App
import com.example.composelab.screens.ScreenBg
import com.example.composelab.screens.Task01Counter
import com.example.composelab.screens.Task02Likes
import com.example.composelab.screens.Task03Product
import com.example.composelab.screens.Task04Wallet
import com.example.composelab.screens.Task05Temperature
import com.example.composelab.screens.Task06Light
import com.example.composelab.screens.Task07Profile
import com.example.composelab.screens.Task08Quiz
import com.example.composelab.screens.Task09Tips
import com.example.composelab.screens.Task10Progress
import com.example.composelab.screens.TextDark
import com.example.composelab.screens.TextGray
import com.example.composelab.screens.WhiteCard

private class LabScreen(val title: String, val content: @Composable () -> Unit)

private val labScreens = listOf(
    LabScreen("1. Профиль пользователя") { Screen01Profile() },
    LabScreen("2. Карточка товара") { Screen02Product() },
    LabScreen("3. Статистика") { Screen03Stats() },
    LabScreen("4. Экран настроек") { Screen04Settings() },
    LabScreen("5. Dashboard") { Screen05Dashboard() },
    LabScreen("6. Карточка заказа") { Screen06Order() },
    LabScreen("7. Профиль разработчика") { Screen07Developer() },
    LabScreen("8. Экран банковской карты") { Screen08BankCard() },
    LabScreen("9. Профиль + статистика + информация") { Screen09ProfileInfo() },
    LabScreen("10. Финальное задание — экран приложения") { Screen10App() },
)

private val taskScreens = listOf(
    LabScreen("1. Счётчик") { Task01Counter() },
    LabScreen("2. Лайки") { Task02Likes() },
    LabScreen("3. Карточка товара (логика)") { Task03Product() },
    LabScreen("4. Баланс кошелька") { Task04Wallet() },
    LabScreen("5. Регулятор температуры") { Task05Temperature() },
    LabScreen("6. Управление освещением") { Task06Light() },
    LabScreen("7. Карточка профиля") { Task07Profile() },
    LabScreen("8. Мини-викторина") { Task08Quiz() },
    LabScreen("9. Калькулятор чаевых") { Task09Tips() },
    LabScreen("10. Счётчик выполненных задач") { Task10Progress() },
)

private val allScreens = labScreens + taskScreens

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                LabApp()
            }
        }
    }
}

/** Меню из 10 заданий; тап по пункту открывает экран, «назад» возвращает в меню. */
@Composable
private fun LabApp() {
    var selected by rememberSaveable { mutableStateOf(-1) }

    BackHandler(enabled = selected >= 0) { selected = -1 }

    Box(modifier = Modifier.fillMaxSize().background(ScreenBg).systemBarsPadding()) {
        if (selected >= 0) {
            allScreens[selected].content()
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                Text(
                    text = "10 заданий на верстку",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextDark,
                )
                Text(
                    text = "Row, Column, Card, Box, Text",
                    fontSize = 14.sp,
                    color = TextGray,
                    modifier = Modifier.padding(bottom = 6.dp),
                )
                allScreens.forEachIndexed { index, screen ->
                    if (index == labScreens.size) {
                        Text(
                            text = "Практические задания (с логикой)",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = TextDark,
                            modifier = Modifier.padding(top = 16.dp),
                        )
                    }
                    WhiteCard(
                        modifier = Modifier.fillMaxWidth().clickable { selected = index },
                        corner = 14.dp,
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth().padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Text(
                                text = screen.title,
                                fontSize = 16.sp,
                                color = TextDark,
                                modifier = Modifier.weight(1f),
                            )
                            Text(text = ">", fontSize = 18.sp, color = TextGray)
                        }
                    }
                }
            }
        }
    }
}
