package com.jesse.composeryt

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class BoxActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Boxx()
        }
    }
}

@Preview(showBackground = true)

@Composable
fun Boxx(){
    Column(
        modifier = Modifier.fillMaxSize().background(Color.Gray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier
            .size(200.dp)
            .background(Color.LightGray)
        ) {
            Box(modifier = Modifier.background(Color.Black).size(100.dp).align(Alignment.TopStart))
            Box(modifier = Modifier.background(Color.Black).size(100.dp).align(Alignment.BottomEnd))
        }
    }
}



@Composable
fun BoxWithGpt(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Image(
            painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = null,
            Modifier.fillMaxSize()
        )

        Text(
            modifier = Modifier,
            text = "testandoo o boxx",
            fontSize = 44.sp
        )
    }
}
