package com.jesse.dia1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jesse.dia1.ui.theme.Dia1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Dia1Theme {
                Surface(modifier = Modifier.fillMaxSize()){
                    ExeDia1()
                }
            }
        }
    }
}

@Composable
fun ExeDia1(modifier: Modifier = Modifier){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.DarkGray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Hello Composer",
            Modifier.background(color = Color.Black, shape = RoundedCornerShape(14.dp))
                .padding(22.dp),
            fontSize = 34.sp,
            color = Color.White,
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Dia1Theme {
        ExeDia1()
    }
}