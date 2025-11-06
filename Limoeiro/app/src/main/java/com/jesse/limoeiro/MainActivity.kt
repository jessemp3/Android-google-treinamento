package com.jesse.limoeiro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jesse.limoeiro.ui.theme.LimoeiroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LimoeiroTheme {
                   Limoeiro(modifier = Modifier
                       .fillMaxSize()
                       .wrapContentSize(Alignment.Center)
                   )
            }
        }
    }
}

@Composable
fun Limoeiro(modifier: Modifier = Modifier) {
    val imagens = listOf(
        R.drawable.lemon_tree,
        R.drawable.lemon_squeeze,
        R.drawable.lemon_drink,
        R.drawable.lemon_restart
    )

    val texts = listOf(
        "primeira imagem",
        "segunda imagem",
        "terceira imagem",
        "quarta imagem"
    )

    var currentIndex by remember { mutableStateOf(0) }


    Column(modifier = modifier
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        IconButton(
            modifier = Modifier.size(200.dp),
            onClick = {
                currentIndex = (currentIndex + 1) % imagens.size
            }
        ) {
            Image(
                painter = painterResource(id = imagens[currentIndex]),
                contentDescription = texts[0],
                Modifier.background(Color.Green)
                    .padding(16.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = texts[currentIndex],
            fontSize = 20.sp
        )

    }
}

@Preview(showBackground = true)
@Composable
fun LemonPreview() {
    LimoeiroTheme {
        Limoeiro()
    }
}

