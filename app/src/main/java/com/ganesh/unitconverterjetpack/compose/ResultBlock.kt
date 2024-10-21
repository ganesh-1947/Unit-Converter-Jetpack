package com.ganesh.unitconverterjetpack.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ResultBlock(messageOne: String, messageTwo: String, modifier: Modifier = Modifier) {
    Card (
        elevation = CardDefaults.cardElevation(defaultElevation = 20.dp),
        modifier = modifier.padding(top = 20.dp)
    ){
        Column(modifier = modifier.padding(10.dp)) {
            Text(text = messageOne, fontSize = 28.sp)
            Text(text = messageTwo, fontSize = 28.sp, color = Color.Blue, fontWeight = FontWeight.Bold)
        }
    }

}