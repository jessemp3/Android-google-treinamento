package com.jesse.financeapp.Activities.dashboardActivity.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jesse.financeapp.R

@Preview()
@Composable
fun HeaderSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 48.dp, end = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = "Hello Pitter Jackson",
                color = Color.Blue,
                fontSize = 19.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Hpitterjackson@gmail.com",
                color = Color.Blue,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp
            )
        }
        Image(
            painter = painterResource(R.drawable.men),
            contentDescription = null,
            modifier = Modifier.size(50.dp)
        )


    }
}