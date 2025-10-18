package com.jesse.tasksmanagercomposer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jesse.tasksmanagercomposer.ui.theme.TasksManagerComposerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TasksManagerComposerTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    GreetingImage(
                        message = "All tasks completed",
                        secondMessage = "Nice work!"
                    )
                }
            }
        }
    }
}


@Composable()
fun GreetingImage(message: String, secondMessage: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.ic_task_completed),
            contentDescription = null,
        )

        Text(
            text = message,
            modifier = Modifier.padding(0.dp, 24.dp, 0.dp, 8.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
        )

        Text(
            text = secondMessage,
            fontSize = 16.sp
        )

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TasksManagerComposerTheme {
        GreetingImage(
            message = "All tasks completed",
            secondMessage = "Nice work!"
        )
    }
}