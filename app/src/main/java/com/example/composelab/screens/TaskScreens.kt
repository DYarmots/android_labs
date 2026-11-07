package com.example.composelab.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Locale

private val Blue = Color(0xFF2F6BEA)
private val Red = Color(0xFFE5484D)
private val RedBg = Color(0xFFFDE8E8)

private fun money(n: Int) = String.format(Locale.US, "%,d", n).replace(',', ' ') + " ₽"

@Composable
private fun Heading(text: String) =
    Text(text = text, fontSize = 22.sp, fontWeight = FontWeight.Bold, color = TextDark)

@Composable
private fun BigText(text: String) =
    Text(text = text, fontSize = 44.sp, fontWeight = FontWeight.Bold, color = TextDark, textAlign = TextAlign.Center)

/** Цветная плашка с сообщением. */
@Composable
private fun Notice(text: String, bg: Color = GreenBg, fg: Color = GreenFg) {
    Box(
        modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(12.dp)).background(bg).padding(14.dp),
        contentAlignment = Alignment.Center,
    ) {
        Text(text = text, color = fg, fontSize = 14.sp, fontWeight = FontWeight.Medium, textAlign = TextAlign.Center)
    }
}

@Composable
private fun RowScope.Btn(text: String, enabled: Boolean = true, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        enabled = enabled,
        modifier = Modifier.weight(1f),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Blue),
    ) { Text(text) }
}

@Composable
private fun FullBtn(text: String, enabled: Boolean = true, color: Color = Blue, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        enabled = enabled,
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(containerColor = color),
    ) { Text(text) }
}

@Composable
private fun SoftBtn(text: String, enabled: Boolean = true, onClick: () -> Unit) {
    FilledTonalButton(
        onClick = onClick,
        enabled = enabled,
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
    ) { Text(text) }
}

// ---------- 1. Счётчик ----------
@Composable
fun Task01Counter() {
    var count by remember { mutableIntStateOf(0) }
    ScreenRoot {
        Heading("Счётчик")
        BigText("$count")
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            Btn("−1", enabled = count > 0) { count-- }
            Btn("+1", enabled = count < 10) { count++ }
        }
        SoftBtn("Сбросить") { count = 0 }
        if (count == 10) Notice("Максимум достигнут")
    }
}

// ---------- 2. Лайки ----------
@Composable
fun Task02Likes() {
    var liked by remember { mutableStateOf(false) }
    val likes = if (liked) 1 else 0
    ScreenRoot {
        Heading("Публикация")
        Text("Красивый закат на море", color = TextGray, fontSize = 14.sp)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Brush.verticalGradient(listOf(Color(0xFF5B7FD1), Color(0xFFF2A65A), Color(0xFFE8695A)))),
            contentAlignment = Alignment.Center,
        ) { Text("🌅", fontSize = 64.sp) }
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(if (liked) "❤️" else "🤍", fontSize = 28.sp)
            Text("$likes", fontSize = 22.sp, fontWeight = FontWeight.Bold, color = TextDark)
        }
        FullBtn(
            text = if (liked) "Не нравится" else "Нравится",
            color = if (liked) Red else Blue,
        ) { liked = !liked }
    }
}

// ---------- 3. Карточка товара ----------
@Composable
fun Task03Product() {
    val price = 2500
    var qty by remember { mutableIntStateOf(1) }
    var bought by remember { mutableStateOf(false) }
    ScreenRoot {
        WhiteCard(Modifier.fillMaxWidth()) {
            Column(Modifier.fillMaxWidth().padding(18.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Box(
                    Modifier.fillMaxWidth().height(120.dp).clip(RoundedCornerShape(14.dp)).background(Color(0xFFE3EAD9)),
                    contentAlignment = Alignment.Center,
                ) { Text("🎒", fontSize = 64.sp) }
                Column {
                    Text("Рюкзак", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = TextDark)
                    Text("Удобный городской рюкзак", fontSize = 13.sp, color = TextGray)
                }
                Text(money(price), fontSize = 24.sp, fontWeight = FontWeight.ExtraBold, color = TextDark)
                Row(
                    Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                ) {
                    Btn("−", enabled = qty > 1) { qty--; bought = false }
                    Text("$qty", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = TextDark)
                    Btn("+") { qty++; bought = false }
                }
                Text("Итого: ${money(price * qty)}", fontSize = 15.sp, color = TextGray)
                FullBtn("Купить") { bought = true }
                if (bought) Notice("Товар добавлен!\n$qty шт. на сумму ${money(price * qty)}")
            }
        }
    }
}

// ---------- 4. Баланс кошелька ----------
@Composable
fun Task04Wallet() {
    var balance by remember { mutableIntStateOf(1000) }
    ScreenRoot {
        Heading("Мой кошелёк")
        BigText(money(balance))
        FullBtn("Пополнить +500 ₽", color = GreenFg) { balance += 500 }
        FullBtn("Снять −500 ₽", enabled = balance >= 500, color = Red) { balance -= 500 }
        if (balance < 500) Notice("На счету меньше 500 ₽", RedBg, Red)
    }
}

// ---------- 5. Регулятор температуры ----------
@Composable
fun Task05Temperature() {
    var temp by remember { mutableIntStateOf(22) }
    val label = when {
        temp > 25 -> "Жарко"
        temp < 20 -> "Прохладно"
        else -> "Комфортная температура"
    }
    val (bg, fg) = when {
        temp > 25 -> RedBg to Red
        temp < 20 -> Color(0xFFE3F0FF) to Blue
        else -> GreenBg to GreenFg
    }
    ScreenRoot {
        Heading("Температура")
        BigText("$temp °C")
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            Btn("−", enabled = temp > 16) { temp-- }
            Btn("+", enabled = temp < 30) { temp++ }
        }
        Notice(label, bg, fg)
    }
}

// ---------- 6. Управление освещением ----------
@Composable
fun Task06Light() {
    var on by remember { mutableStateOf(false) }
    ScreenRoot {
        Box(
            Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp))
                .background(if (on) Color(0xFFFFF3C4) else Color(0xFFE4E6EC))
                .padding(24.dp),
            contentAlignment = Alignment.Center,
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text("💡", fontSize = 72.sp)
                Text("Освещение", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = TextDark)
                if (on) Notice("Включено") else Notice("Выключено", Color(0xFFD5D8E0), TextGray)
            }
        }
        FullBtn(if (on) "Выключить" else "Включить") { on = !on }
        SoftBtn("Выключить", enabled = on) { on = false }
    }
}

// ---------- 7. Карточка профиля ----------
@Composable
fun Task07Profile() {
    var shown by remember { mutableStateOf(false) }
    var age by remember { mutableIntStateOf(25) }
    ScreenRoot {
        Avatar(size = 110.dp, glyph = "👨")
        Text("Иван", fontSize = 22.sp, fontWeight = FontWeight.Bold, color = TextDark)
        Text("$age лет", fontSize = 14.sp, color = TextGray)
        if (shown) {
            Notice("Android-разработчик из Москвы. Любит Kotlin и Jetpack Compose.", Color(0xFFE4E8FB), Color(0xFF4A5BC4))
        }
        FullBtn(if (shown) "Скрыть информацию" else "Показать информацию") { shown = !shown }
        SoftBtn("Изменить возраст") { age++ }
    }
}

// ---------- 8. Мини-викторина ----------
private class Question(val text: String, val options: List<String>, val correct: Int)

private val questions = listOf(
    Question("Какой язык используется для разработки Android приложений?", listOf("Kotlin", "Python"), 0),
    Question("Как называется современный UI-тулкит Android?", listOf("Jetpack Compose", "Tkinter"), 0),
    Question("Какая функция запускает Compose-экран в Activity?", listOf("setContentView", "setContent"), 1),
)

@Composable
fun Task08Quiz() {
    var index by remember { mutableIntStateOf(0) }
    var score by remember { mutableIntStateOf(0) }
    var chosen by remember { mutableIntStateOf(-1) }
    var finished by remember { mutableStateOf(false) }
    val q = questions[index]

    ScreenRoot {
        if (finished) {
            Heading("Викторина завершена")
            BigText("$score из ${questions.size}")
            FullBtn("Начать заново") { index = 0; score = 0; chosen = -1; finished = false }
        } else {
            Text("Вопрос ${index + 1} из ${questions.size}", color = TextGray, fontSize = 13.sp)
            Text(q.text, fontSize = 18.sp, fontWeight = FontWeight.Bold, color = TextDark)
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                q.options.forEachIndexed { i, option ->
                    val color = when {
                        chosen == -1 -> Blue
                        i == q.correct -> GreenFg
                        i == chosen -> Red
                        else -> Color.Gray
                    }
                    Button(
                        onClick = {
                            if (chosen == -1) {
                                chosen = i
                                if (i == q.correct) score++
                            }
                        },
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = color, disabledContainerColor = color),
                    ) { Text(option) }
                }
            }
            if (chosen != -1) {
                if (chosen == q.correct) Notice("Правильно!\nВаш счёт: $score")
                else Notice("Неверно.\nВаш счёт: $score", RedBg, Red)
                FullBtn(if (index == questions.lastIndex) "Показать результат" else "Следующий вопрос") {
                    if (index == questions.lastIndex) finished = true else { index++; chosen = -1 }
                }
            }
        }
    }
}

// ---------- 9. Калькулятор чаевых ----------
@Composable
fun Task09Tips() {
    val bill = 2000
    var percent by remember { mutableIntStateOf(10) }
    val tip = bill * percent / 100
    ScreenRoot {
        Heading("Счёт в ресторане")
        BigText(money(bill))
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            listOf(5, 10, 15).forEach { p ->
                if (p == percent) {
                    Btn("$p%") { percent = p }
                } else {
                    OutlinedButton(
                        onClick = { percent = p },
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(12.dp),
                    ) { Text("$p%") }
                }
            }
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text("Чаевые:", color = TextGray, fontSize = 16.sp)
            Text(money(tip), fontWeight = FontWeight.Bold, color = TextDark, fontSize = 16.sp)
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text("Итого:", color = TextGray, fontSize = 16.sp)
            Text(money(bill + tip), fontWeight = FontWeight.Bold, color = TextDark, fontSize = 16.sp)
        }
    }
}

// ---------- 10. Счётчик выполненных задач ----------
@Composable
fun Task10Progress() {
    val goal = 5
    var done by remember { mutableIntStateOf(0) }
    ScreenRoot {
        Heading("Мои задачи")
        BigText("$done из $goal")
        LinearProgressIndicator(
            progress = { done / goal.toFloat() },
            modifier = Modifier.fillMaxWidth().height(10.dp).clip(RoundedCornerShape(5.dp)),
            color = Blue,
        )
        FullBtn("Выполнить задачу", enabled = done < goal) { done++ }
        SoftBtn("Отменить", enabled = done > 0) { done-- }
        if (done == goal) Notice("Все задачи выполнены!")
        SoftBtn("Сбросить") { done = 0 }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun TaskPreview() = Task08Quiz()
