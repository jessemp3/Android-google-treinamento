package com.jesse.composeryt

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CanvasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Canvas()
        }
    }
}

@Composable
fun Canvas(){
    Column(
        modifier = Modifier.fillMaxSize()
            .background(Color.DarkGray)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Canvas(
           modifier = Modifier.fillMaxWidth().height(350.dp)
               .background(Color.White),
            onDraw = {
               drawRect(
                   color = Color.Black,
                   // aqui se usa float , não dp
                   size = Size(
                       width = 200f,
                       height = 200f
                   ),
                   topLeft = Offset(
                       100f,// horizontal
                       350f // vertical
                   )
               )

                drawCircle(
                    color = Color.Blue,
                    radius = 100f
                )
            }
        )
    }
}


@Preview(showBackground = true)
@Composable
fun CanvasPreview(){
    Canvas()
}