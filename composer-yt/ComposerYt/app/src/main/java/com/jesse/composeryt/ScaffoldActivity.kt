package com.jesse.composeryt

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.ColorRes
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview


class ScaffoldActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Homes()
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Homes(){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {Text("Aula de Scaffold")},
                colors = TopAppBarDefaults.topAppBarColors(Color.Blue, titleContentColor = Color.White),
                actions = {
                    Icon(
                        imageVector = Icons.Rounded.Home,
                        tint = Color.White,
                        contentDescription = null
                    )
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = Color.Blue,
            ) {

            }
        }
    ) {paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("jesse")
            Text("jesse")
        }
    }
}

@Composable
@Preview(showBackground = true)
fun HomePreview(){
    Homes()
}