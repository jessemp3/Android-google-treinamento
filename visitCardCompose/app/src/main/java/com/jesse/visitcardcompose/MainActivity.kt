package com.jesse.visitcardcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter.Companion.tint
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jesse.visitcardcompose.ui.theme.VisitCardComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VisitCardComposeTheme {
                Surface (modifier = Modifier.fillMaxSize()) {
                    VisitCard()
                }
            }
        }
    }
}

@Composable
private fun VisitCard(modifier: Modifier = Modifier) {
    Column(
        modifier.fillMaxSize()
            .background(Color(0xFFC6F5D3)),
    ){
        Column(
            modifier = Modifier
                // não esquecer de por o weight/height/width senão não funciona como esperado
                // e as merdas do vertical slaoq e o horizontalAlignment tbm não funcionam
                .weight(1f)
                .fillMaxWidth()
            ,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                painter = androidx.compose.ui.res.painterResource(R.drawable.android_logo),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Black)
                    .padding(16.dp)
            )

            Text(
                text = "Jesse Alves",
                modifier = Modifier,
                fontSize = 36.sp
            )

            Text(
                text = "Android Developer",
                modifier = Modifier,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF238A56)
            )
        }

       Column (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom,
        ){
           Row(
               modifier = Modifier
                   .width(190.dp),
               horizontalArrangement = Arrangement.SpaceBetween,
           ) {
               Icon(
                     painter = androidx.compose.ui.res.painterResource(R.drawable.baseline_phone_24),
                     contentDescription = null,
                     modifier = Modifier,

                     tint = Color(0xFF238A56)
               )

               Text(
                     text = "   +55 11 91234-5678",
                     modifier = Modifier,
               )
           }

           Row(
               modifier = Modifier
                   .width(190.dp),
               horizontalArrangement = Arrangement.SpaceBetween,
           ) {
               Icon(
                   painter = androidx.compose.ui.res.painterResource(R.drawable.baseline_share_24),
                   contentDescription = null,
                   modifier = Modifier.padding(end = 8.dp),
                   tint = Color(0xFF238A56)
               )

               Text(
                   text = "@jesseDev",
                   modifier = Modifier,
               )
           }

           Row(
               modifier = Modifier,
               horizontalArrangement = Arrangement.SpaceBetween,
           ) {
               Icon(
                   painter = androidx.compose.ui.res.painterResource(R.drawable.baseline_email_24),
                   contentDescription = null,
                   modifier = Modifier.padding (end = 8.dp),
                   tint = Color(0xFF238A56)
               )

               Text(
                   text = "jesseAlves@gmail.com",
                   modifier = Modifier,
               )
           }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    VisitCardComposeTheme {
        VisitCard( )
    }
}