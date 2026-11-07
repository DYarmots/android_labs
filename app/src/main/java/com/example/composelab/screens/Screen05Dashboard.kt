package com.example.composelab.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
private fun RowScope.SmallCard(value: String, label: String) {
    WhiteCard(modifier = Modifier.weight(1f), corner = 16.dp) {
        Column(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
            Text(text = value, fontSize = 30.sp, fontWeight = FontWeight.Bold, color = TextDark)
            Text(text = label, fontSize = 14.sp, color = TextGray)
        }
    }
}

/** 5. Dashboard: Row из двух карточек (weight 1f) + широкая карточка снизу. */
@Composable
fun Screen05Dashboard() {
    ScreenRoot {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(14.dp),
        ) {
            Text(
                text = "Dashboard",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = TextDark,
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                SmallCard("124", "Orders")
                SmallCard("82%", "Conversion")
            }
            WhiteCard(modifier = Modifier.fillMaxWidth(), corner = 16.dp) {
                Column(modifier = Modifier.fillMaxWidth().padding(20.dp)) {
                    Text(text = "Revenue", fontSize = 15.sp, color = TextDark)
                    Text(
                        text = "124 500 ₽",
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextDark,
                        modifier = Modifier.padding(top = 6.dp),
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun Screen05Preview() = Screen05Dashboard()
