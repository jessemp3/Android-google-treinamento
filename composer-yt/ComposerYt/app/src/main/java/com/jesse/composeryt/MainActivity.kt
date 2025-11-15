package com.jesse.composeryt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Home()
        }
    }
}

// no jetpack compose , funcoes com a anotação composable devem começar com letra maiuscula
@Composable
fun Home(){
//    Column(
//        modifier = Modifier
////            .fillMaxWidth()
////            .fillMaxHeight()
//            .fillMaxSize()
//            .background(color = Color.Gray),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ) {
//        Surface(
//            modifier = Modifier.size(100.dp).weight(8f),
//            color = Color.Green
//        ) {
//
//        }
//
//        Surface(
//            modifier = Modifier.size(100.dp).weight(2f),
//            color = Color.Red
//        ) {
//
//        }
//    }


    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Gray),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
    ) {
        Surface(
            modifier = Modifier.size(100.dp),
            color = Color.Green
        ) {

        }

        Surface(
            modifier = Modifier.size(100.dp),
            color = Color.Red
        ) {

        }
    }
}

@Preview(showBackground = true)
@Composable
fun CadastroPreview(){
    Home()
}
