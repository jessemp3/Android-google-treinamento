package com.jesse.limoeiro

import android.os.Bundle
import android.widget.Button
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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

@OptIn(ExperimentalMaterial3Api::class)
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


    TopAppBar(
        title = {Text("Limoeiro")},
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFFC3ECD2)
        )
    )

    Column(modifier = modifier
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            modifier = Modifier.size(200.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFC3ECD2)
            ),
            onClick = {
                currentIndex = (currentIndex + 1) % imagens.size
            }
        ) {
            Image(
                painter = painterResource(id = imagens[currentIndex]),
                contentDescription = texts[0],
                Modifier.padding(16.dp)
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

