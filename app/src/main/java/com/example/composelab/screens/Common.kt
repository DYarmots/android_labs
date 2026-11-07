package com.example.composelab.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val ScreenBg = Color(0xFFF1F4FB)
val TextDark = Color(0xFF1A2233)
val TextGray = Color(0xFF6B7488)
val LineGray = Color(0xFFE6E9F2)
val AvatarBg = Color(0xFFDDE3F7)
val GreenBg = Color(0xFFD9F4E3)
val GreenFg = Color(0xFF1F8A4C)

/** Корень экрана: светлый фон, отступы, содержимое по центру, прокрутка на маленьких экранах. */
@Composable
fun ScreenRoot(
    horizontalPadding: Dp = 16.dp,
    content: @Composable ColumnScope.() -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ScreenBg)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = horizontalPadding, vertical = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        content = content,
    )
}

/** Белая карточка с мягкой тенью. */
@Composable
fun WhiteCard(
    modifier: Modifier = Modifier,
    corner: Dp = 20.dp,
    content: @Composable ColumnScope.() -> Unit,
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(corner),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
        content = content,
    )
}

/** Круглый аватар: вместо Image/Icon рисуем эмодзи внутри Box. */
@Composable
fun Avatar(size: Dp, glyph: String = "👤", bg: Color = AvatarBg) {
    Box(
        modifier = Modifier.size(size).clip(CircleShape).background(bg),
        contentAlignment = Alignment.Center,
    ) {
        Text(text = glyph, fontSize = (size.value * 0.45f).sp)
    }
}

/** Маленькая таблетка со статусом. */
@Composable
fun Badge(text: String, bg: Color = GreenBg, fg: Color = GreenFg) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(50))
            .background(bg)
            .padding(horizontal = 12.dp, vertical = 5.dp),
        contentAlignment = Alignment.Center,
    ) {
        Text(text = text, color = fg, fontSize = 12.sp, fontWeight = FontWeight.Medium)
    }
}

/** Горизонтальная линия-разделитель из Box. */
@Composable
fun HDivider(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxWidth().height(1.dp).background(LineGray))
}
