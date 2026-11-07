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

/** Строка товара: слева название и количество, справа цена (через weight(1f) у левой части). */
@Composable
private fun OrderLine(name: String, qty: String, price: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top,
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(text = name, fontSize = 17.sp, fontWeight = FontWeight.Medium, color = TextDark)
            Text(text = qty, fontSize = 13.sp, color = TextGray)
        }
        Text(text = price, fontSize = 16.sp, fontWeight = FontWeight.Medium, color = TextDark)
    }
}

/** 6. Карточка заказа: строки с левым и правым контентом. */
@Composable
fun Screen06Order() {
    ScreenRoot {
        WhiteCard(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier.fillMaxWidth().padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = "Заказ #12345",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextDark,
                    )
                    Badge(text = "Доставлен")
                }

                OrderLine("MacBook Air", "1 × 129 990 ₽", "129 990 ₽")
                OrderLine("iPhone 17", "2 × 89 990 ₽", "179 980 ₽")

                HDivider()

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = "Итого",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextDark,
                        modifier = Modifier.weight(1f),
                    )
                    Text(
                        text = "309 970 ₽",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = TextDark,
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun Screen06Preview() = Screen06Order()
