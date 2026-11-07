package com.example.composelab.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
private fun RowScope.StatCard(value: String, label: String) {
    WhiteCard(modifier = Modifier.weight(1f).height(150.dp), corner = 16.dp) {
        Column(
            modifier = Modifier.fillMaxWidth().height(150.dp).padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = value,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = TextDark,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
            )
            Text(text = label, fontSize = 13.sp, color = TextGray, textAlign = TextAlign.Center)
        }
    }
}

/** 3. Статистика: три карточки одинаковой ширины через weight(1f). */
@Composable
fun Screen03Stats() {
    ScreenRoot {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            StatCard("128", "Projects")
            StatCard("42", "Followers")
            StatCard("17", "Following")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun Screen03Preview() = Screen03Stats()
