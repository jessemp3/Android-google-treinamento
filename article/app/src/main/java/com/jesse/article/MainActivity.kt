package com.jesse.article

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jesse.article.ui.theme.ArticleTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArticleTheme {
                Surface (modifier = Modifier.fillMaxSize()) {
                    GreetingImage(
                        modifier = Modifier.padding(0.dp, 0.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingImage(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Top,
        modifier = modifier.fillMaxSize()
    ) {
    Image(
        painter = painterResource(R.drawable.bg_compose_background),
        contentDescription = null,
        contentScale = ContentScale.FillWidth,
        modifier = modifier
    )

        GreetingTitle(
            title = "Jetpack Compose tutorial", modifier = Modifier.padding(16.dp),
            litleMessage = "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs",
            bigText = "In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app\\'s UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI\\'s construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name."
        )
}
}

@Composable
fun GreetingTitle(title: String, litleMessage: String,bigText: String, modifier: Modifier = Modifier) {
    Text(
        text = title,
        modifier = modifier.padding(0.dp, 24.dp, 0.dp, 0.dp),
        fontSize = 24.sp
    )
    Text(
        text = litleMessage,
        modifier = modifier.padding(0.dp, 16.dp),
    )

    Text(
        text = bigText,
        modifier = modifier.padding(16.dp),
        textAlign = TextAlign.Justify
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArticleTheme {
        GreetingImage()
    }
}